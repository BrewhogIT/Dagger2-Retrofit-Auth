package com.brewhog.android.daggerretrofitauthorization.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brewhog.android.daggerretrofitauthorization.login.LoginRepository
import com.brewhog.android.daggerretrofitauthorization.login.LoginViewModel
import com.brewhog.android.daggerretrofitauthorization.moto.MotoRepository
import com.brewhog.android.daggerretrofitauthorization.moto.MotoViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor (val loginRepository: LoginRepository,
                                            val motoRepository: MotoRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(
                loginRepository
            ) as T
        }else if (modelClass.isAssignableFrom(MotoViewModel::class.java)){
            return MotoViewModel(motoRepository) as T
        }
        else{
            throw IllegalArgumentException("no one correct class")
        }
    }
}