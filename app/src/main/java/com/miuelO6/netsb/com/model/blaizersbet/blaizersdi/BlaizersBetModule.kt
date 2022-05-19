package com.miuelO6.netsb.com.model.blaizersbet.blaizersdi

import com.miuelO6.netsb.com.model.blaizersbet.BlaizersBetModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlaizersBetModule {

    @Singleton
    @Provides
    fun provideBlaizersBet(): BlaizersBetModel = BlaizersBetModel()
}