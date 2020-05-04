package com.brewhog.android.daggerretrofitauthorization.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brewhog.android.daggerretrofitauthorization.model.Login

class LoginViewModel(val loginRepository: LoginRepository) : ViewModel() {
    val email : MutableLiveData<String> = MutableLiveData()
    val password : MutableLiveData<String> = MutableLiveData()
    val check : MutableLiveData<Boolean> = MutableLiveData()
    val loginMutableLiveData : MutableLiveData<Login> = MutableLiveData()

    fun login(view : View){
        val login = Login(email.value!!,password.value!!)
        loginRepository.apiLogin(login,view)
    }

}