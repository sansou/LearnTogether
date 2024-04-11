package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        title = stringResource(R.string.titulo),
                        resumo = stringResource(R.string.resumo),
                        corpo = stringResource(R.string.corpo)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(title: String, resumo: String, corpo: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 100.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = resumo,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = corpo,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Composable
fun GreetingImage(title: String, resumo: String, corpo: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            title = title,
            resumo = resumo,
            corpo = corpo,
            modifier = Modifier.fillMaxSize()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        GreetingImage(
            title = stringResource(R.string.titulo),
            resumo = stringResource(R.string.resumo),
            corpo = stringResource(R.string.corpo)
        )
    }
}