package com.espezzialy.news_compose_app.data.remote.dto

import com.espezzialy.news_compose_app.domain.model.Article

data class NewsReponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)