package com.espezzialy.news_compose_app.domain.useCases.news

import androidx.paging.PagingData
import com.espezzialy.news_compose_app.domain.model.Article
import com.espezzialy.news_compose_app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>) : Flow<PagingData<Article>>
    {
        return newsRepository.getNews(sources = sources)

    }
}