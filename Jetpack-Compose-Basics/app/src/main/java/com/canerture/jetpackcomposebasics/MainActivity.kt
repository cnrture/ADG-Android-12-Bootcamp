package com.canerture.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canerture.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                Conversation(arrayListOf(
                    Message("Android 1", "Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1"),
                    Message("Android 2", "Hello 2"),
                    Message("Android 3", "Hello 3"),
                    Message("Android 4", "Hello 4")
                ))
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

    var isExpanded by remember { mutableStateOf(false) }

    val surfaceColor: androidx.compose.ui.graphics.Color by animateColorAsState(
        if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    )

            Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 1.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {

            Image(
                painter = painterResource(R.drawable.profil_picture),
                contentDescription = "Contact profil picture",
                modifier = Modifier
                    .size(size = 40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {

                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)
                ) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {

    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "Light Mode")

@Composable
fun SecondPreview() {
    JetpackComposeBasicsTheme {
        Conversation(arrayListOf(
            Message("Android 1", "Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1, Hello 1"),
            Message("Android 2", "Hello 2"),
            Message("Android 3", "Hello 3"),
            Message("Android 4", "Hello 4")
        ))
    }
}