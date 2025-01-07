package com.intel_Jan03.songlyicstranslation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslatorOptions
import com.intel_Jan03.songlyicstranslation.ui.theme.SongLyicsTranslationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SongLyicsTranslationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val db = Mydb.getDatabase(context)
    val scope = rememberCoroutineScope()
//    LaunchedEffect(Unit) {
//        scope.launch(Dispatchers.IO) {
//        db.musicDao().insertMusic(newMusic)
//        }
//    }

    //translation
    var transText by remember { mutableStateOf("") }

    val enKoTranslator = remember {
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.KOREAN)
            .build()

        Translation.getClient(options)
    }
    var isReady by remember { mutableStateOf(false) }
    LaunchedEffect(enKoTranslator) {
        var conditions = DownloadConditions.Builder()
            .build()
        enKoTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                isReady = true
            }
            .addOnFailureListener {
                Toast.makeText(context, "transLator Download Failed!!", Toast.LENGTH_SHORT).show()
            }
    }
    //

    var song by remember { mutableStateOf<String>("See You Again") }
    var singer by remember { mutableStateOf<String>("Charlie Puth") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = song,
            onValueChange = { song = it },
            label = { Text("노래 제목 입력") }
        )
        TextField(
            value = singer,
            onValueChange = { singer = it },
            label = { Text("가수 이름 입력") }
        )
        Button(
            onClick = {
                var lyicsTrans = ""
                scope.launch(Dispatchers.IO) {
                    //음악 정보 조회
                    val musics = db.musicDao().getMusic()
                    val music = musics.find { it.song == song && it.singer == singer }

                    //동일 제목의 노래 목록 띄우기
//                    val music = musics.filter { it.song == song && it.singer == singer }

                    if (music != null) {
                        lyicsTrans = music.lyics ?: "No lyrics available"

                        enKoTranslator.translate(lyicsTrans)
                            .addOnSuccessListener { translatedText ->
                                // Translation successful.
                                transText = translatedText
//                                scope.launch(Dispatchers.Main){
//                                    Toast.makeText(context, transText, Toast.LENGTH_SHORT).show()
//                                }
                                val moveTheScreen = Intent(context, LyicsVeiwerActivity::class.java)
                                moveTheScreen.putExtra("TRANSLATED_TEXT", transText) // transText 변수를 이동할 페이지에 전달
                                context.startActivity(moveTheScreen)
                            }
                            .addOnFailureListener { exception ->
                                // Error.
                                transText = "translation False:("
//                                scope.launch(Dispatchers.Main){
//                                    Toast.makeText(context, transText, Toast.LENGTH_SHORT).show()
//                                }
                                transToast(scope, context, transText)
                            }
                    } else {
                        // 음악을 찾지 못한 경우
                        transText = "No matching song found!"
//                        scope.launch(Dispatchers.Main) {
//                            Toast.makeText(context, transText, Toast.LENGTH_SHORT).show()
//                        }
                        transToast(scope, context, transText)
                    }
                }
            },
            enabled = isReady,
        ) {
            Text("검색")
        }
        Text(transText)
    }
}

