package com.example.devvoca.presentation.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.preference.PreferenceManager
import com.example.devvoca.R
import com.example.devvoca.data.Entity.UserInfo
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.LoginToken
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var oneTapClient : SignInClient
    lateinit var signInRequest :BeginSignInRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(PreferenceManager.getDefaultSharedPreferences(baseContext).getString("name","")=="")
        {
            Log.e("DevVoca","없음")
        }
        else
        {
            Log.e("DevVoca","있음")
            finish()
            startActivity(Intent(this,MainActivity::class.java))
        }

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)  //google 로그인 옵션 객체
            .requestEmail()
            .requestIdToken(getString(R.string.default_web_client_id))  //idToken 값
            .build()

        var mGoogleSignInClient = GoogleSignIn.getClient(this,gso)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())    //activityResult 객체 생성 (activity 실행 후 결과를 받아온다.)
        { result ->
            if(result.resultCode == RESULT_OK)  //결과 받을 경우
            {
                val data: Intent? = result.data
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                Log.e("test","token 길이 : ${task.result.idToken?.toString()?.length}")
                var idToken = task.result.idToken!!
                var email = task.result.email!!
                var name = task.result.displayName!!

                //sharedPreferences에 저장
                PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
                    putString("idToken",idToken)
                    putString("email",email)
                    putString("name",name)
                }.apply()

                //backend 연동 부분
                //TODO : loginToken, refreshToken을 활용하는 방법을 찾아보도록 한다.
                RetrofitCon.getAuthService().loginAuthToBackEnd("google",LoginToken(idToken,email,name,"request"))
                    .enqueue(object: Callback<UserInfo>{
                        override fun onResponse(
                            call: Call<UserInfo>,
                            response: Response<UserInfo>
                        )
                        {
                            RetrofitCon.setLoginInfoData(response.body()!!)
                            Log.e("test","응답 옴 ${response.body()}")
                        }

                        override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                            Log.e("test","실패, ${t.message} ")

                        }
                    })
                finish()
                startActivity(Intent(baseContext,MainActivity::class.java))
                Log.e("test",task.result.idToken.toString())
            }
        }

        findViewById<SignInButton>(R.id.testbutton1)
            .setOnClickListener {
                var signinIntent = mGoogleSignInClient.signInIntent
                resultLauncher.launch(signinIntent)
            }
    }
}