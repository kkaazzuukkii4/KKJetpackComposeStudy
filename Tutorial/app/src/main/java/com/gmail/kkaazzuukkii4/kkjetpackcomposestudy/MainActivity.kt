package com.gmail.kkaazzuukkii4.kkjetpackcomposestudy

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.kkaazzuukkii4.kkjetpackcomposestudy.ui.theme.KKJetpackComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KKJetpackComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.image_kinoshita),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember {
            mutableStateOf(false)
        }
        val surfaceColor by animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surface
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.width(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp,
                color = surfaceColor, modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Colleague", "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" + "Android KitKat (API 19)\n" + "Android Lollipop (API 21)\n" + "Android Marshmallow (API 23)\n" + "Android Nougat (API 24)\n" + "Android Oreo (API 26)\n" + "Android Pie (API 28)\n" + "Android 10 (API 29)\n" + "Android 11 (API 30)\n" + "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" + "It's so much fun!"
        ),
        Message(
            "Colleague", "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" + "It's the Android's modern toolkit for building native UI." + "It simplifies and accelerates UI development on Android." + "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague", "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague", "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague", "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague", "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague", "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague", "Have you tried writing build.gradle with KTS?"
        ),

        Message(
            "Colleague", "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" + "Android KitKat (API 19)\n" + "Android Lollipop (API 21)\n" + "Android Marshmallow (API 23)\n" + "Android Nougat (API 24)\n" + "Android Oreo (API 26)\n" + "Android Pie (API 28)\n" + "Android 10 (API 29)\n" + "Android 11 (API 30)\n" + "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" + "It's so much fun!"
        ),
        Message(
            "Colleague", "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" + "It's the Android's modern toolkit for building native UI." + "It simplifies and accelerates UI development on Android." + "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague", "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague", "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague", "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague", "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague", "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague", "Have you tried writing build.gradle with KTS?"
        ),
    )
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages.size) { index ->
            MessageCard(messages.get(index))
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    KKJetpackComposeStudyTheme {
        MessageCard(Message("Kazuki", "Hello I love to play baseball!"))
    }
}

@Preview
@Composable
fun PreviewConversation() {
    KKJetpackComposeStudyTheme {
        Conversation(SampleData.conversationSample)
    }
}