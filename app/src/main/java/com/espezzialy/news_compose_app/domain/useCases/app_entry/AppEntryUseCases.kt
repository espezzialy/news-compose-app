package com.espezzialy.news_compose_app.domain.useCases.app_entry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntryUseCase,
    val saveAppEntry: SaveAppEntryUseCase
)
