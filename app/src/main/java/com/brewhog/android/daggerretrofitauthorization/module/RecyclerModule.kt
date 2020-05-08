package com.brewhog.android.daggerretrofitauthorization.module

import com.brewhog.android.daggerretrofitauthorization.model.Moto
import com.brewhog.android.daggerretrofitauthorization.util.MotoAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerModule {

    @Provides
    fun getAdapter() : MotoAdapter{
        return MotoAdapter(listOf())
    }
}