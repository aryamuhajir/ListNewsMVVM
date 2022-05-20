package com.example.listnewsmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listnewsmvvm.R
import com.example.listnewsmvvm.adapter.RvAdapter
import com.example.listnewsmvvm.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : ViewModelNews
    lateinit var adapterNews : RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterNews = RvAdapter()

        viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)

        getDataNews()
    }

    fun getDataNews(){
        viewModel.getDataNewsObserver().observe(this){
            if (it != null){
                rv_item.layoutManager = LinearLayoutManager(this)
                rv_item.adapter = adapterNews
                adapterNews.setDataNews(it)
                adapterNews.notifyDataSetChanged()
            }
        }

        viewModel.makeApiNews()
    }
}