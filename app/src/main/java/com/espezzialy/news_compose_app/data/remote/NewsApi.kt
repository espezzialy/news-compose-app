package com.espezzialy.news_compose_app.data.remote

import com.espezzialy.news_compose_app.data.remote.dto.NewsReponse
import com.espezzialy.news_compose_app.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsReponse
}