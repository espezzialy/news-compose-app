package com.espezzialy.news_compose_app.domain.repository

import androidx.paging.PagingData
import com.espezzialy.news_compose_app.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>
}