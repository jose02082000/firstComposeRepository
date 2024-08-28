package com.example.helloworldcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @Preview
    @Composable
    fun App() {
        var counter by rememberSaveable { mutableStateOf(0) }

        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(16.dp)
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp),// preguntar
                    painter = painterResource(id = R.drawable.fondo),
                    contentDescription = "logo"
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_fav),
                        contentDescription = "like",
                        modifier = Modifier.clickable { counter++ }
                    )
                    Text(
                        text = counter.toString(),
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Text(
                    text = "Hola",
                    fontSize = 40.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(text = "Android dev", color = Color.White)
                Text(text = "mi primer job", color = Color.White)

                LazyRow(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        Text(text = "Contratame: ", color = Color.White)
                        Text(text = "por favor", color = Color.White)
                        Text(text = "si?", color = Color.White)
                    }
                }
            }
        }
    }
}

