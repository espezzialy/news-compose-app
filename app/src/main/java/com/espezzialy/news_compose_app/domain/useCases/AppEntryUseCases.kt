package com.espezzialy.news_compose_app.domain.useCases

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntryUseCase,
    val saveAppEntry: SaveAppEntryUseCase
)
