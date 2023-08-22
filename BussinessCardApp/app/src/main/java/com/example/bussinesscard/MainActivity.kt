package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageAndText()
                }
            }
        }
    }
}




@Composable
fun ImageAndText(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color.White)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .background(Color.Blue)
            )

            Text(
                text = "Thanh Truong",
                style = MaterialTheme.typography.displayLarge
            )

            Text(
                text = "Android Developer Extraordinaire",
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            bottom = 20.dp
        )
    ){
        PersonalInfo()
    }

}


@Composable
fun PersonalInfo(){
    Column {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = "0357203489")
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = "@AndroidDev")
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = "thanhtruong1901@gmail.com")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        ImageAndText()
    }
}