package com.intel_Jan03.songlyicstranslation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.intel_Jan03.songlyicstranslation.ui.theme.SongLyicsTranslationTheme

class LyicsVeiwerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //super: 부모에 정의된 onCreate 실행
        setContent {
            SongLyicsTranslationTheme {
                LyicsVeiwerScreen()
            }
        }
    }
}

@Composable
private fun LyicsVeiwerScreen() {

}