package com.espezzialy.news_compose_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.espezzialy.news_compose_app.domain.useCases.app_entry.AppEntryUseCases
import com.espezzialy.news_compose_app.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().collect {shouldStartFromHomeScreen ->
                startDestination = if(shouldStartFromHomeScreen) {
                    Route.NewsNavigation.route
                } else {
                    Route.AppStartNavigation.route
                }
                delay(1000)
                splashCondition  = false
            }
        }
    }
}