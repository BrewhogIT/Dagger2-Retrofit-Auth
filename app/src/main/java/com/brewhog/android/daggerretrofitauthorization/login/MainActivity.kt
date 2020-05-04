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
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val activityBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityBinding.loginViewModel = loginViewModel
    }
}
