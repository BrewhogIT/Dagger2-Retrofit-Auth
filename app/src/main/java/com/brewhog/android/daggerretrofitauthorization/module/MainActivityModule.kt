package com.brewhog.android.daggerretrofitauthorization.module

import com.brewhog.android.daggerretrofitauthorization.login.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ContributesAndroidInjector
    fun contributesMainActivity() : MainActivity
}