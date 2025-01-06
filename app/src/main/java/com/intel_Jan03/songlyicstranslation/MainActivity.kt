package com.intel_Jan03.songlyicstranslation

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intel_Jan03.songlyicstranslation.ui.theme.SongLyicsTranslationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val db = Mydb.getDatabase(context)
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
//            db.musicDao().insertMusic(newMusic)
        }
    }

    var song by remember { mutableStateOf<String>("") }
    var singer by remember { mutableStateOf<String>("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
        Button(onClick = {
            var lyicsTrans = db.musicDao().loadLyics()


        }) {
            Text("검색")
        }
    }
}

    val newMusic = Music(
        song = "See You Again", singer = "Charlie Puth",
        lyics = "It's been a long day without you, my friend\n" +
                "And I'll tell you all about it when I see you again\n" +
                "We've come a long way from where we began\n" +
                "Oh, I'll tell you all about it when I see you again\n" +
                "When I see you again\n" +
                "Damn, who knew?\n" +
                "All the planes we flew, good things we been through\n" +
                "That I'd be standin' right here talkin' to you\n" +
                "'Bout another path, I know we loved to hit the road and laugh\n" +
                "But somethin' told me that it wouldn't last\n" +
                "Had to switch up, look at things different, see the bigger picture\n" +
                "Those were the days, hard work forever pays\n" +
                "Now I see you in a better place (see you in a better place)\n" +
                "Uh\n" +
                "How can we not talk about family when family's all that we got?\n" +
                "Everythin' I went through, you were standin' there by my side\n" +
                "And now you gon' be with me for the last ride\n" +
                "It's been a long day without you, my friend\n" +
                "And I'll tell you all about it when I see you again (I'll see you again)\n" +
                "We've come a long way (yeah, we came a long way)\n" +
                "From where we began (you know where we started)\n" +
                "Oh, I'll tell you all about it when I see you again (let me tell you)\n" +
                "When I see you again\n" +
                "Oh, oh\n" +
                "Ooh (yeah)\n" +
                "First, you both go out your way and the vibe is feelin' strong\n" +
                "And what's small turned to a friendship, a friendship turned to a bond\n" +
                "And that bond'll never be broken, the love will never get lost\n" +
                "(The love never get lost)\n" +
                "And when brotherhood come first, then the line'll never be crossed\n" +
                "Established it on our own when that line had to be drawn\n" +
                "And that line is what we reached, so remember me when I'm gone\n" +
                "(Remember me when I'm gone)\n" +
                "How can we not talk about family when family's all that we got?\n" +
                "Everythin' I went through, you were standin' there by my side\n" +
                "And now you gon' be with me for the last ride\n" +
                "So let the light guide your way, yeah\n" +
                "Hold every memory as you go\n" +
                "And every road you take\n" +
                "Will always lead you home, home\n" +
                "It's been a long day without you, my friend\n" +
                "And I'll tell you all about it when I see you again\n" +
                "We've come a long way from where we began\n" +
                "Oh, I'll tell you all about it when I see you again\n" +
                "When I see you again\n" +
                "Oh (uh), oh (yeah-yeah, yeah)\n" +
                "Ooh (yo, yo, uh)\n" +
                "When I see you again (see you again, yeah, yeah)\n" +
                "Oh (yeah), oh (yeah, yeah, oh-oh)\n" +
                "Ooh (uh-huh, yup)\n" +
                "When I see you again",
    )
