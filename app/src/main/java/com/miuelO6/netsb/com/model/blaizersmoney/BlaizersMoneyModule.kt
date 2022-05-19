package com.miuelO6.netsb.com.model.blaizersmoney

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlaizersMoneyModule {

    @Singleton
    @Provides
    fun provideBlaizersMoneyDataStore(
        @ApplicationContext blaizersContext: Context,
    ): BlaizersMoneyDataStore = BlaizersMoneyDataStore(blaizersContext)
}