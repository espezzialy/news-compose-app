package com.espezzialy.news_compose_app.di

import android.app.Application
import com.espezzialy.news_compose_app.data.manager.LocalUserManagerImpl
import com.espezzialy.news_compose_app.data.remote.NewsApi
import com.espezzialy.news_compose_app.data.repository.NewsRepositoryImpl
import com.espezzialy.news_compose_app.domain.manager.LocalUserManager
import com.espezzialy.news_compose_app.domain.repository.NewsRepository
import com.espezzialy.news_compose_app.domain.useCases.app_entry.AppEntryUseCases
import com.espezzialy.news_compose_app.domain.useCases.app_entry.ReadAppEntryUseCase
import com.espezzialy.news_compose_app.domain.useCases.app_entry.SaveAppEntryUseCase
import com.espezzialy.news_compose_app.domain.useCases.news.GetNewsUseCase
import com.espezzialy.news_compose_app.domain.useCases.news.NewsUseCases
import com.espezzialy.news_compose_app.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi : NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)
    @Provides
    @Singleton
    fun provideNewsUSeCases(
        newsRepository: NewsRepository
    ) = NewsUseCases(
        getNewsUseCase = GetNewsUseCase(newsRepository)
    )
}