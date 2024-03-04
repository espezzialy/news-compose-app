package com.espezzialy.news_compose_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.espezzialy.news_compose_app.domain.useCases.AppEntryUseCases
import com.espezzialy.news_compose_app.presentation.onboarding.OnBoardingScreen
import com.espezzialy.news_compose_app.presentation.onboarding.OnBoardingViewModel
import com.espezzialy.news_compose_app.ui.theme.NewscomposeappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)


        installSplashScreen()

        setContent {
            NewscomposeappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel : OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        /*
                        The implementation below is the same that
                        event = viewModel::onEvent
                        * */
                        event = {
                            viewModel.onEvent(it)
                        }
                    )
                }
            }
        }
    }
}
