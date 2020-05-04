package com.brewhog.android.daggerretrofitauthorization.component

import android.app.Application
import com.brewhog.android.daggerretrofitauthorization.App
import com.brewhog.android.daggerretrofitauthorization.module.MainActivityModule
import com.brewhog.android.daggerretrofitauthorization.module.RetrofitModule
import com.brewhog.android.daggerretrofitauthorization.module.SharedPreferencesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,MainActivityModule::class,RetrofitModule::class,SharedPreferencesModule::class])
interface MyComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():MyComponent
    }

    fun inject(app : App)
}