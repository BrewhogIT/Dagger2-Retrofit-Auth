package com.brewhog.android.daggerretrofitauthorization.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*
import javax.inject.Inject

class ViewModelFactory @Inject constructor (val loginRepository: LoginRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(loginRepository) as T
        }else{
            throw IllegalArgumentException("no one correct class")
        }
    }
}