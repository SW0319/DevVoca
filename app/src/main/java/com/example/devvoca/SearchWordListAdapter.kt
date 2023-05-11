package com.example.devvoca

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class SearchWordListAdapter(var words: ArrayList<Word>, var con: Context) :
    RecyclerView.Adapter<SearchWordListAdapter.ViewHolder>(), Filterable {

    var filteredWords = ArrayList<Word>()
    private var itemFilter = ItemFilter()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var word: TextView
        var mean: TextView

        init {
            word = itemView.findViewById(R.id.item_search_word_list_word)
            mean = itemView.findViewById(R.id.item_search_word_list_mean)

            itemView.setOnClickListener {
                AlertDialog.Builder(con).apply {
                    val position = adapterPosition
                    val person = filteredWords[position]
                    setTitle(person.word)
                    setMessage(person.mean)
                    setPositiveButton("OK") { _, _ ->
                        Toast.makeText(con, "OK Button Click", Toast.LENGTH_SHORT).show()
                    }
                    show()
                }
            }
        }
    }

    init {
        filteredWords.addAll(words)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.items_search_word_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word: Word = filteredWords[position]
        //[수정요함] 이미지 작업의 경우 glide를 사용해 server의 image를 불러올 것
        //holder.iv_person_phone_book_list_item
        holder.word.text = word.word
        holder.mean.text = word.mean
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }

    //-- filter
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        // 입력받은 문자열에 대한 처리
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<Word> = ArrayList()

            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isNotEmpty()) {
                for (person in words) {
                    if (person.word.contains(filterString) || person.mean.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        //처리에 대한 결과물
        @SuppressLint("NotifyDataSetChanged")
        @Suppress("UNCHECKED_CAST")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {

            filteredWords.clear()
            filteredWords.addAll(filterResults.values as ArrayList<Word>)
            notifyDataSetChanged()
        }
    }
}