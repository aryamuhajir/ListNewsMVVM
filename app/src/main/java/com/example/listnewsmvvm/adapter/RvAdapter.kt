package com.example.listnewsmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.listnewsmvvm.R
import com.example.listnewsmvvm.model.GetAllNewsResponseItem
import kotlinx.android.synthetic.main.item_adapter.view.*

class RvAdapter() : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private var dataNews : List<GetAllNewsResponseItem>? = null

    fun setDataNews(news : List<GetAllNewsResponseItem>){
        this.dataNews = news
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.judulNews.text = dataNews!![position].title
        holder.itemView.tanggalNews.text = dataNews!![position].createdAt
        holder.itemView.penulisNews.text = dataNews!![position].author
        Glide.with(holder.itemView.context).load(dataNews!![position].image).apply(RequestOptions().override(120, 120)).into(holder.itemView.imageNews)





    }

    override fun getItemCount(): Int {
        if (dataNews == null){
            return 0
        }else{
            return dataNews!!.size

        }
    }
}