package com.example.individualproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.individualproject.R
import com.example.individualproject.data.MyViewModel
import com.example.individualproject.data.ServiceRepository

import com.example.individualproject.database.QuoteEntity
import com.example.individualproject.model.Quote
import kotlinx.coroutines.*

class ItemAdapter(private val dataset: List<Quote>, val viewModel: MyViewModel)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private var isLoadingMore = false
    private var data: MutableList<Quote> = dataset as MutableList<Quote>

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.title)
        val textView1: TextView = view.findViewById(R.id.charac)
        val textView2: TextView = view.findViewById(R.id.quote)
        val button:Button=view.findViewById(R.id.addToFavs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.anime
        holder.textView1.text = item.character
        holder.textView2.text = item.quote
        holder.button.setOnClickListener {

            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    viewModel.insertMyEntity(QuoteEntity(item.anime,item.character,item.quote))
                }
            }
            }
        // If user reached the end of the list, load more items
        if (!isLoadingMore && position == dataset.size - 1) {
            isLoadingMore = true
            CoroutineScope(Dispatchers.Main).launch {
                data.addAll(loadMoreItems())
                notifyDataSetChanged()
            }
        }
    }

    private suspend fun loadMoreItems(): Collection<Quote> {
        isLoadingMore = false
        return ServiceRepository().loadQuotes()
    }

}