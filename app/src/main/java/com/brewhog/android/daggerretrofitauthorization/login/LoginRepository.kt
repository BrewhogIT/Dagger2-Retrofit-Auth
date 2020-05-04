package com.brewhog.android.daggerretrofitauthorization.login

import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import com.brewhog.android.daggerretrofitauthorization.MotoActivity
import com.brewhog.android.daggerretrofitauthorization.model.Login
import com.brewhog.android.daggerretrofitauthorization.model.Token
import com.brewhog.android.daggerretrofitauthorization.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(var api: Api, var sharedPreferences: SharedPreferences) {
    var mainActivity : MainActivity? = null
    var check = false

    fun apiLogin(login: Login, view: View){
        api.login(login).enqueue(object : Callback<Token>{
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                Toast.makeText(view.context,"Wrong Credentials!",Toast.LENGTH_LONG).show()
                println("ERROR $t")
            }

            override fun onResponse(call: Call<Token>?, response: Response<Token>?) {
                sharedPreferences.edit()
                    .putString("token",response?.body()?.token)
                    .apply()
                println("token ===>>> ${sharedPreferences.getString("token","default")}")

                newActivity(view)
            }

        })
    }

    fun newActivity(view : View){
        val intent = Intent(view.context,MotoActivity::class.java)
        view.context.startActivity(intent)
    }

    // Login("Andrew", "password")
}