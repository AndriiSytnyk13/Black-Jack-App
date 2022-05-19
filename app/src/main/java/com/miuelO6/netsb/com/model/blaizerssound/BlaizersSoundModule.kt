package com.miuelO6.netsb.com.model.blaizerssound

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlaizersSoundModule {

    @Singleton
    @Provides
    fun provideBlaizersSoundDataStore(
        @ApplicationContext blaizersContext: Context,
    ): BlaizersSoundDataStore = BlaizersSoundDataStore(blaizersContext)
}