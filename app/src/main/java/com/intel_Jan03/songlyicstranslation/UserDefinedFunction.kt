package com.intel_Jan03.songlyicstranslation

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun newMusic(): Music {
    val newMusic1 = Music(
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

    val newMusic2 = Music(
        song = "Architect", singer = "Livingston",
        lyics = "Every word you said runs around inside my head again\n" +
                "Every conversation with myself, my God, a therapist\n" +
                "No, you can't resist, you're the name of my apocalypse\n" +
                "Thank the Lord, I didn't fall for it\n" +
                "But something inside of me wants to change the earth\n" +
                "Build my kingdom, watch it burn\n" +
                "Chase a feeling, lift the curse\n" +
                "Teachers told me I'd never learn\n" +
                "I won't be the last, but you won't be the first\n" +
                "Hit when I'm kneeling, do your worst\n" +
                "'Cause I'll take all your sticks and stones\n" +
                "Turn 'em into miracles\n" +
                "Let me let you know, oh-ooh, oh-ooh, oh\n" +
                "I'm never gonna want your pity\n" +
                "Oh, no, no, look at you so cynical\n" +
                "But if I let it go, oh-ooh, oh-ooh, oh\n" +
                "Who else is gonna build this city?\n" +
                "'Cause we are who we say we are\n" +
                "And that's just fine\n" +
                "'Cause I was never gonna take them with me\n" +
                "Sticks and stones\n" +
                "Turn 'em into miracles\n" +
                "Let me let you know, oh-ooh, oh-ooh, oh\n" +
                "Nobody else is gonna build my city\n" +
                "Drag me through the dark, be the villain in my narrative\n" +
                "Dance upon my scars, how I truly love your arrogance\n" +
                "Future felt far 'til you opened up the door for it\n" +
                "Oh, you opened up the door for it\n" +
                "But something inside of me wants to change the earth\n" +
                "Build my kingdom, watch it burn\n" +
                "Chase a feeling, lift the curse\n" +
                "Teachers told me I'd never learn\n" +
                "I won't be the last, but you won't be the first\n" +
                "Hit when I'm kneeling, do your worst\n" +
                "'Cause I'll take all your sticks and stones\n" +
                "Turn 'em into miracles\n" +
                "Let me let you know, oh-ooh, oh-ooh, oh\n" +
                "I'm never gonna want your pity\n" +
                "Oh, no, no, look at you so cynical\n" +
                "But if I let it go, oh-ooh, oh-ooh, oh\n" +
                "Who else is gonna build this city?\n" +
                "Nothing is left, I'm letting you in\n" +
                "Take what you want, take my lies, and my sin\n" +
                "Knew you were staying, so I built a city\n" +
                "Where all my shadows and demons can live\n" +
                "Nothing is left, I'm letting you in\n" +
                "Take what you want, take my lies, and my sin\n" +
                "Knew you were staying, so I built a city\n" +
                "Where all my shadows and demons can live\n" +
                "Sticks and stones\n" +
                "Turn 'em into miracles\n" +
                "Let me let you know, oh-ooh, oh-ooh, oh\n" +
                "Nobody else is gonna build my city\n" +
                "Sticks and stones\n" +
                "Turn 'em into miracles\n" +
                "Let me let you know, oh-ooh, oh-ooh, oh"

    )

    val newMusic3 = Music(
        song = "Trouble", singer = "Christopher, 이영지",
        lyics = "Ooh\n" +
                "Ooh\n" +
                "Ooh\n" +
                "Ooh\n" +
                "I see the way that you blush at me\n" +
                "Tell me why it's so uncomfortable\n" +
                "Every time we meet\n" +
                "Whatever you're thinking just let it be\n" +
                "Don't say that you still have dreams about me\n" +
                "Do you still have dreams about me?\n" +
                "I'm not looking for trouble\n" +
                "I'm pretending it's not tempting\n" +
                "But, oh, it's a struggle\n" +
                "Trouble keep finding me (trouble keep finding me)\n" +
                "Trying my best not to mess around\n" +
                "'Cause she's gonna bring me down\n" +
                "And I'm not looking for trouble\n" +
                "But trouble keep finding me, uh\n" +
                "Mm\n" +
                "Mm\n" +
                "Mm\n" +
                "Mm\n" +
                "Last night I dreamed about you\n" +
                "Don't tell my boyfriend that I did it again\n" +
                "White lies with a small kiss, kiss\n" +
                "Baby, I'm that type of girl, quit playing\n" +
                "And I'ma get a new mascara ('cara), complicated drama (drama)\n" +
                "Running from the trouble makes you cause another karma (karma)\n" +
                "Marry, kill, what? Don't hesitate, baby\n" +
                "'Cause I'm that big trouble you need\n" +
                "I'm not looking for trouble\n" +
                "I'm pretending it's not tempting\n" +
                "But, oh, it's a struggle (struggle)\n" +
                "Trouble keeps finding me (trouble keeps finding me)\n" +
                "Trying my best not to mess around\n" +
                "'Cause she's gonna bring me down\n" +
                "And I'm not looking for trouble\n" +
                "But trouble keep finding me\n" +
                "Sounds so good when it kicks in like that, uh\n" +
                "Let me get it\n" +
                "Bring it in\n" +
                "I'm not looking for trouble\n" +
                "I'm pretending it's not tempting\n" +
                "But, oh, it's a struggle (struggle)\n" +
                "But trouble keep finding me\n" +
                "Trying my best not to mess around\n" +
                "'Cause she's gonna bring me down\n" +
                "And I'm not looking for trouble (trouble)\n" +
                "But trouble keep finding me (oh, it's just like)\n" +
                "Trouble keep finding me (mm)\n" +
                "Trouble keep finding me (mm, alright)\n" +
                "Trouble keep finding me (mm)\n" +
                "Trouble keep finding me"
    )

    val newMusic4 = Music(
        song = "Shallow", singer = "Lady Gaga, Bradley Cooper",
        lyics = "Tell me something, girl\n" +
                "Are you happy in this modern world?\n" +
                "Or do you need more?\n" +
                "Is there something else you're searchin' for?\n" +
                "I'm falling\n" +
                "In all the good times, I find myself longin' for change\n" +
                "And in the bad times, I fear myself\n" +
                "Tell me something, boy\n" +
                "Aren't you tired trying to fill that void?\n" +
                "Or do you need more?\n" +
                "Ain't it hard keeping it so hardcore?\n" +
                "I'm falling\n" +
                "In all the good times, I find myself longing for change\n" +
                "And in the bad times, I fear myself\n" +
                "I'm off the deep end, watch as I dive in\n" +
                "I'll never meet the ground\n" +
                "Crash through the surface, where they can't hurt us\n" +
                "We're far from the shallow now\n" +
                "In the sha-ha, sha-ha-llow\n" +
                "In the sha-ha-sha-la-la-la-llow\n" +
                "In the sha-ha, sha-ha-llow\n" +
                "We're far from the shallow now\n" +
                "Oh, ha-ah-ah\n" +
                "Ah, ha-ah-ah, oh, ah\n" +
                "Ha-ah-ah-ah\n" +
                "I'm off the deep end, watch as I dive in\n" +
                "I'll never meet the ground\n" +
                "Crash through the surface, where they can't hurt us\n" +
                "We're far from the shallow now\n" +
                "In the sha-ha, sha-ha-llow\n" +
                "In the sha-ha-sha-la-la-la-llow\n" +
                "In the sha-ha, sha-ha-llow\n" +
                "We're far from the shallow now"
    )

    val newMusic5 = Music(
        song = "I'm Not The Only One", singer = "Sam Smith",
        lyics = "One, two, three, four\n" +
                "Mm-mm, mm\n" +
                "Mm-mm-mm, mm\n" +
                "Yeah\n" +
                "You and me, we made a vow\n" +
                "For better or for worse, hmm\n" +
                "And I can't believe you let me down\n" +
                "But the proof's in the way it hurts, mm, yeah\n" +
                "For months on end, I've had my doubts\n" +
                "Denyin' every tear\n" +
                "And I wish this would be over now\n" +
                "But I know that I still need you near\n" +
                "You say I'm crazy\n" +
                "'Cause you don't think I know what you've done\n" +
                "But when you call me \"baby\"\n" +
                "I know I'm not the only one, mm, yeah\n" +
                "You've been so unavailable\n" +
                "Now, sadly, I know why\n" +
                "And your heart is unobtainable\n" +
                "Even though Lord knows you kept mine\n" +
                "You say I'm crazy\n" +
                "'Cause you don't think I know what you've done\n" +
                "But when you call me \"baby\"\n" +
                "I know I'm not the only one\n" +
                "And I have loved you for many years\n" +
                "Maybe I am just not enough\n" +
                "Ooh, you've made me realize my deepest fear\n" +
                "By lyin' and tearin' us up\n" +
                "You say I'm crazy\n" +
                "'Cause you don't think I know what you've done\n" +
                "But when you call me \"baby\"\n" +
                "I know I'm not the only one\n" +
                "And I know I'm not the only one\n" +
                "I know I'm not the only one\n" +
                "And I know, and I know, and I know, and I know, and I know, and I know\n" +
                "I know I'm not the only one"
    )

    val newMusic = Music(
        song = "", singer = "",
        lyics = ""
    )

    return newMusic1
}


fun transToast(scope: CoroutineScope, context: Context, transText: String) {
    scope.launch(Dispatchers.Main){
        Toast.makeText(context, transText, Toast.LENGTH_SHORT).show()
    }
}

