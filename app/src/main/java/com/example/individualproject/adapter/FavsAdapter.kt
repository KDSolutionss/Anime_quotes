package com.example.individualproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.individualproject.R
import com.example.individualproject.model.Quote

class FavsAdapter(dataset: List<Quote>): RecyclerView.Adapter<FavsAdapter.FavsItemViewHolder>() {
    private var data: MutableList<Quote> = dataset as MutableList<Quote>
    class FavsItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.title)
        val textView1: TextView = view.findViewById(R.id.charac)
        val textView2: TextView = view.findViewById(R.id.quote)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavsItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_favs, parent, false)

        return FavsItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FavsItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.anime
        holder.textView1.text = item.character
        holder.textView2.text = item.quote
    }
}