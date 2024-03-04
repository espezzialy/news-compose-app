package com.espezzialy.news_compose_app.di

import android.app.Application
import com.espezzialy.news_compose_app.data.manager.LocalUserManagerImpl
import com.espezzialy.news_compose_app.domain.manager.LocalUserManager
import com.espezzialy.news_compose_app.domain.useCases.AppEntryUseCases
import com.espezzialy.news_compose_app.domain.useCases.ReadAppEntryUseCase
import com.espezzialy.news_compose_app.domain.useCases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntryUseCase(localUserManager),
        saveAppEntry = SaveAppEntryUseCase(localUserManager)
    )
}