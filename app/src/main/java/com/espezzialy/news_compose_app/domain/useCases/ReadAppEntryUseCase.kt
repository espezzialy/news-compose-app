package com.espezzialy.news_compose_app.domain.useCases

import com.espezzialy.news_compose_app.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase (
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}