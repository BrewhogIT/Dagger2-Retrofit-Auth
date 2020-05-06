package com.brewhog.android.daggerretrofitauthorization

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brewhog.android.daggerretrofitauthorization.model.Moto
import com.brewhog.android.daggerretrofitauthorization.model.Token
import com.brewhog.android.daggerretrofitauthorization.network.Api
import dagger.android.AndroidInjection
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

class MotoActivity : AppCompatActivity() {
    @Inject
    lateinit var api : Api
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moto)
        api.getMoto()
            .enqueue(object : Callback<List<Moto>>{
                override fun onFailure(call: Call<List<Moto>>?, t: Throwable?) {
                    println("onFailure")
                }

                override fun onResponse(call: Call<List<Moto>>?, response: Response<List<Moto>>?) {
                    println(response?.body() ?: "empty list")
                    println(sharedPreferences.getString("token","empty token"))
                }

            })
    }
}
