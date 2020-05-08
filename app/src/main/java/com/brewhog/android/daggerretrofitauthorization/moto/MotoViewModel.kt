package com.brewhog.android.daggerretrofitauthorization.moto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brewhog.android.daggerretrofitauthorization.model.Moto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MotoViewModel(val motoRepository: MotoRepository) : ViewModel(){
    var motoLiveData = MutableLiveData<List<Moto>>()

    init {
        getMotoList()
    }

    fun getMotoList(){
        motoRepository.getMoto().enqueue(object : Callback<List<Moto>> {
                override fun onFailure(call: Call<List<Moto>>?, t: Throwable?) {
                    println("MotoViewModel - onFailure")
                }

                override fun onResponse(call: Call<List<Moto>>?, response: Response<List<Moto>>?) {
                    println("MotoViewModel get list ===> ${response?.body() }")
                    motoLiveData.value = response?.body()
                }
            })
    }
}