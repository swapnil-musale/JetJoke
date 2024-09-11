package com.devx.jetjoke

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.EXTRA_TEXT
import android.content.Intent.createChooser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.devx.jetjoke.navigation.AppNavGraph
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.ui.actions.AppActions
import com.devx.jetjoke.ui.actions.ShareJokeAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            JetJokeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavGraph(action = ::performActions)
                }
            }
        }
    }


    private fun performActions(action: AppActions){
        when(action){
            is ShareJokeAction -> {
                shareJoke(action.joke)
            }
        }
    }

    private fun shareJoke(jokeText:String){
        val shareIntent = Intent(ACTION_SEND).apply {
            type = "text/plain"
            putExtra(EXTRA_TEXT, jokeText)
        }
        val chooserIntent = createChooser(shareIntent, null)
        this.startActivity(chooserIntent)
    }
}
