package com.espezzialy.news_compose_app.domain.useCases

import com.espezzialy.news_compose_app.domain.manager.LocalUserManager

class SaveAppEntryUseCase (
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}