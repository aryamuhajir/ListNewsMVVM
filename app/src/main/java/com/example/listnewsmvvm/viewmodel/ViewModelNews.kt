package com.example.listnewsmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listnewsmvvm.model.GetAllNewsResponseItem
import com.example.listnewsmvvm.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel() {
    lateinit var dataNews : MutableLiveData<List<GetAllNewsResponseItem>>

    init {
        dataNews = MutableLiveData()
    }

    fun getDataNewsObserver() : MutableLiveData<List<GetAllNewsResponseItem>>{
        return dataNews
    }

    fun makeApiNews(){
        APIClient.instance.getAllNews()
            .enqueue(object  : Callback<List<GetAllNewsResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful){
                        dataNews.postValue(response.body())
                    }else{
                        dataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {

                    dataNews.postValue(null)
                }

            })
    }
}