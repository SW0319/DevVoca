package com.example.devvoca

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Filter.FilterResults
import androidx.recyclerview.widget.RecyclerView

class PhoneBookListAdapter(var persons: ArrayList<com.example.devvoca.Person>, var con: Context) :
    RecyclerView.Adapter<PhoneBookListAdapter.ViewHolder>(), Filterable {
    var TAG = "PhoneBookListAdapter"

    var filteredPersons = ArrayList<Person>()
    var itemFilter = ItemFilter()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_person_phone_book_list_item: ImageView
        var tv_name_phone_book_list_item: TextView
        var tv_phone_number_phone_book_list_item: TextView

        init {
            iv_person_phone_book_list_item = itemView.findViewById(R.id.iv_person_phone_book_list_item)
            tv_name_phone_book_list_item = itemView.findViewById(R.id.tv_name_phone_book_list_item)
            tv_phone_number_phone_book_list_item = itemView.findViewById(R.id.tv_phone_number_phone_book_list_item)

            itemView.setOnClickListener {
                AlertDialog.Builder(con).apply {
                    var position = adapterPosition
                    var person = filteredPersons[position]
                    setTitle(person.name)
                    setMessage(person.phoneNumber)
                    setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(con, "OK Button Click", Toast.LENGTH_SHORT).show()
                    })
                    show()
                }
            }
        }
    }

    init {
        filteredPersons.addAll(persons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_phonebook, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: Person = filteredPersons[position]
        //[수정요함] 이미지 작업의 경우 glide를 사용해 server의 image를 불러올 것
        //holder.iv_person_phone_book_list_item
        holder.tv_name_phone_book_list_item.text = person.name
        holder.tv_phone_number_phone_book_list_item.text = person.phoneNumber
    }

    override fun getItemCount(): Int {
        return filteredPersons.size
    }

    //-- filter
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<Person> = ArrayList<Person>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = persons
                results.count = persons.size

                return results
            //공백제외 2글자 이인 경우 -> 이름으로만 검색
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (person in persons) {
                    if (person.name.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
            //그 외의 경우(공백제외 2글자 초과) -> 이름/전화번호로 검색
            } else {
                for (person in persons) {
                    if (person.name.contains(filterString) || person.phoneNumber.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredPersons.clear()
            filteredPersons.addAll(filterResults.values as ArrayList<Person>)
            notifyDataSetChanged()
        }
    }


}