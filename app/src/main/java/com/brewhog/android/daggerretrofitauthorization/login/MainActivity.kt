package com.brewhog.android.daggerretrofitauthorization.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.databinding.DataBindingUtil
import com.brewhog.android.daggerretrofitauthorization.R
import com.brewhog.android.daggerretrofitauthorization.databinding.ActivityMainBinding
import com.brewhog.android.daggerretrofitauthorization.network.Controller
import com.brewhog.android.daggerretrofitauthorization.network.HeaderInterceptor

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val headerInterceptor = HeaderInterceptor(sharedPreferences)
        val controller = Controller(headerInterceptor)
        val api = controller.createService()

        val loginRepository = LoginRepository(api,sharedPreferences)
        val loginViewModel = LoginViewModel(loginRepository)

        val activityBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityBinding.loginViewModel = loginViewModel
    }
}
