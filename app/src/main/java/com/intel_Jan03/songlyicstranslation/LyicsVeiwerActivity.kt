package com.intel_Jan03.songlyicstranslation

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.intel_Jan03.songlyicstranslation.ui.theme.SongLyicsTranslationTheme

class LyicsVeiwerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SongLyicsTranslationTheme {
                LyicsVeiwerScreen()
            }
        }
    }
}

@Composable
private fun LyicsVeiwerScreen() {
    val context = LocalContext.current
    val transText = (context as? Activity)?.intent?.getStringExtra("TRANSLATED_TEXT") ?: "No text available"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(transText)
    }
}
