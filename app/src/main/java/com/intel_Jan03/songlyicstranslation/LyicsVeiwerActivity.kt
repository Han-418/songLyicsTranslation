package com.intel_Jan03.songlyicstranslation

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import com.intel_Jan03.songlyicstranslation.ui.theme.SongLyicsTranslationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LyicsVeiwerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SongLyicsTranslationTheme {
                SpeechToTranslationScreen()
            }
        }
    }
}

private const val REQUEST_CODE_AUDIO = 100

@Composable
private fun SpeechToTranslationScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    //MainActivity에서 전달받은 lyricsText(=lyicsTrans)
    val lyricsText =
        (context as? Activity)?.intent?.getStringExtra("LYRICS_TEXT") ?: "No text available"
    Log.d("Lyrics", "Lyrics Text: $lyricsText")

    var recognizedText by remember { mutableStateOf("") }
    var translatedText by remember { mutableStateOf("") }
    var isListening by remember { mutableStateOf(false) }

    //번역기 설정
    val enKoTranslator = remember {
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.KOREAN)
            .build()
        Translation.getClient(options)
    }

    var isReady by remember { mutableStateOf(false) }

    //번역 모델 다운로드 처리
    LaunchedEffect(Unit) {
        val conditions = DownloadConditions.Builder().build()
        enKoTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                isReady = true
//                Toast.makeText(context, "번역 모델 다운로드 완료!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "번역 모델 다운로드 실패!", Toast.LENGTH_SHORT).show()
            }
    }

    //음성 인식 설정
    val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
    val intent = remember {
        Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US") // 영어 음성 인식
        }
    }

    fun startListening() {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            isListening = true
            speechRecognizer.startListening(intent)
        } else {
            scope.launch(Dispatchers.Main) {
                Toast.makeText(context, "음성 인식 시작 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //음성 인식 결과 처리
    val listener = remember {
        object : android.speech.RecognitionListener {
            override fun onReadyForSpeech(p0: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(p0: Float) {}
            override fun onBufferReceived(p0: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onError(p0: Int) {
                isListening = false
            }

            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null && matches.isNotEmpty()) {
                    recognizedText = matches[0]
                    enKoTranslator.translate(recognizedText)
                        .addOnSuccessListener { translated ->
                            translatedText = translated
                        }
                        .addOnFailureListener { exception ->
                            translatedText = "번역 실패: ${exception.message}"
                            scope.launch(Dispatchers.Main) {
                                Toast.makeText(context, translatedText, Toast.LENGTH_SHORT).show()
                            }
                        }
                    Log.d("SpeechRecognizer", "Recognized text: $recognizedText")
                }
                isListening = false
            }

            override fun onPartialResults(p0: Bundle?) {}
            override fun onEvent(p0: Int, p1: Bundle?) {}
        }
    }

    //(음성 인식 결과 처리)listener 설정
    speechRecognizer.setRecognitionListener(listener)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "원문 가사: \n$lyricsText",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify,
        )
        Text(
            "인식된 텍스트: \n$recognizedText",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify,
        )
        Text(
            "번역된 텍스트: \n$translatedText",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify,
        )

        Button(
            onClick = {
                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.RECORD_AUDIO
                    )
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.RECORD_AUDIO),
                        REQUEST_CODE_AUDIO
                    )
                } else {
                    startListening()
                }
            },
            enabled = !isListening
        ) {
            Text(if (isListening) "음성 인식 중..." else "음성 인식 시작")
        }

        LaunchedEffect(recognizedText) {
            if (recognizedText.isNotEmpty()) {
                translatedText = "번역 중..."
                enKoTranslator.translate(recognizedText)
                    .addOnSuccessListener { translated ->
                        translatedText = translated
                    }
                    .addOnFailureListener { exception ->
                        translatedText = "번역 실패: ${exception.message}"
                        scope.launch(Dispatchers.Main) {
                            Toast.makeText(context, translatedText, Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}
