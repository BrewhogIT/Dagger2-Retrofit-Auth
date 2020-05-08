package com.brewhog.android.daggerretrofitauthorization.moto

import com.brewhog.android.daggerretrofitauthorization.model.Moto
import com.brewhog.android.daggerretrofitauthorization.network.Api
import retrofit2.Call

class MotoRepository(var api : Api) {
    fun getMoto() : Call<List<Moto>>{
        return api.getMoto()
    }
}