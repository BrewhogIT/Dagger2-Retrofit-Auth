package com.brewhog.android.daggerretrofitauthorization.network

import com.brewhog.android.daggerretrofitauthorization.model.Login
import com.brewhog.android.daggerretrofitauthorization.model.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("authorize/login")
    fun login(@Body login: Login) : Call<Token>
}