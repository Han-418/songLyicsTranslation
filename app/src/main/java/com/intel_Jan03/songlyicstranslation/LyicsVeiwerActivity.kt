package com.intel_Jan03.songlyicstranslation

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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
    val transText =
        (context as? Activity)?.intent?.getStringExtra("TRANSLATED_TEXT") ?: "No text available"
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(transText, modifier = Modifier.padding(8.dp))
    }
}
