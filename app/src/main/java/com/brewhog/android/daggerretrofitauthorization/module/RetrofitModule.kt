package com.brewhog.android.daggerretrofitauthorization.module

import android.app.Activity
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brewhog.android.daggerretrofitauthorization.login.LoginRepository
import com.brewhog.android.daggerretrofitauthorization.login.LoginViewModel
import com.brewhog.android.daggerretrofitauthorization.login.MainActivity
import com.brewhog.android.daggerretrofitauthorization.login.ViewModelFactory
import com.brewhog.android.daggerretrofitauthorization.moto.MotoRepository
import com.brewhog.android.daggerretrofitauthorization.network.Api
import com.brewhog.android.daggerretrofitauthorization.network.Controller
import com.brewhog.android.daggerretrofitauthorization.network.HeaderInterceptor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getController(headerInterceptor: HeaderInterceptor):Controller{
        return Controller(headerInterceptor)
    }

    @Singleton
    @Provides
    fun getApi(controller: Controller) : Api{
        return controller.createService()
    }

    @Singleton
    @Provides
    fun getLoginRepository(api : Api, sharedPreferencesModule: SharedPreferences) : LoginRepository{
        return LoginRepository(api,sharedPreferencesModule)
    }

    @Singleton
    @Provides
    fun getMotoRepository(api: Api) : MotoRepository{
        return MotoRepository(api)
    }
}