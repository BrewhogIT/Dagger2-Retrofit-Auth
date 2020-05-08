package com.brewhog.android.daggerretrofitauthorization.moto

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brewhog.android.daggerretrofitauthorization.R
import com.brewhog.android.daggerretrofitauthorization.databinding.ActivityMotoBinding
import com.brewhog.android.daggerretrofitauthorization.login.ViewModelFactory
import com.brewhog.android.daggerretrofitauthorization.model.Moto
import com.brewhog.android.daggerretrofitauthorization.network.Api
import com.brewhog.android.daggerretrofitauthorization.util.MotoAdapter
import dagger.android.AndroidInjection
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

class MotoActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        //TODO Inject
        val motoAdapter = MotoAdapter(listOf())
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MotoViewModel::class.java)
        viewModel.motoLiveData.observe(this, Observer {
            motoAdapter.motoList = it
        })

        val activityMotoBinding = DataBindingUtil.setContentView<ActivityMotoBinding>(
            this,R.layout.activity_moto)
        activityMotoBinding.adapter = motoAdapter

    }
}
