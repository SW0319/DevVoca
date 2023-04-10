package com.example.devvoca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.devvoca.Model.RetrofitCon
import com.example.devvoca.Repo.LoginToken
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var oneTapClient : SignInClient
    lateinit var signInRequest :BeginSignInRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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

                RetrofitCon.getAuthService().loginAuthToBackEnd("google",LoginToken(idToken,email,name,"request"))
                    .enqueue(object: Callback<LoginToken>{
                        override fun onResponse(
                            call: Call<LoginToken>,
                            response: Response<LoginToken>
                        )
                        {

                            Log.e("test","응답 옴 ${response.body()}")
                        }

                        override fun onFailure(call: Call<LoginToken>, t: Throwable) {
                            Log.e("test","실패, ${t.message} ")

                        }
                    })

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