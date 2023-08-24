package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp() {

    var currentImage by remember {
        mutableStateOf(1)
    }

    when (currentImage){
        1 -> {
            ArtImage(
                imageResource = R.drawable.image1,
                onClickNext = { currentImage = 2 },
                onClickPrevious = { currentImage = 5 })
        }

        2 -> {
            ArtImage(
                imageResource = R.drawable.image2,
                onClickNext = { currentImage = 3 },
                onClickPrevious = { currentImage = 1 })
        }

        3 -> {
            ArtImage(
                imageResource = R.drawable.image3,
                onClickNext = { currentImage = 4 },
                onClickPrevious = { currentImage = 2 })
        }

        4 -> {
            ArtImage(
                imageResource = R.drawable.image4,
                onClickNext = { currentImage = 5 },
                onClickPrevious = { currentImage = 3 })
        }

        5 -> {
            ArtImage(
                imageResource = R.drawable.image5,
                onClickNext = { currentImage = 1 },
                onClickPrevious = { currentImage = 4 })
        }
    }

}

@Composable
fun ArtImage(
    imageResource: Int,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
        )

        ButtonNextandPrevious(
            btnNext = onClickNext,
            btnPrevious = onClickPrevious
        )
    }


}


@Composable
fun ButtonNextandPrevious(
    btnNext: () -> Unit,
    btnPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom

    ) {
        Button(
            onClick = btnNext
        ) {
            Text(
                text = stringResource(id = R.string.Previous),
                fontSize = 16.sp
            )
        }

        Button(onClick = btnPrevious) {
            Text(
                text = stringResource(id = R.string.Next),
                fontSize = 16.sp
            )
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {

    }

}