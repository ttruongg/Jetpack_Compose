package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(){
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    when (currentStep){
        1 -> {
            LemonImageAndText(
                imageResoureID = R.drawable.lemon_tree,
                instruction = R.string.lemon_tree_content_description,
                onImageClick = {
                    currentStep = 2;
                    squeezeCount = (2..4).random()
                }
            )
        }

        2 -> {
            LemonImageAndText(
                imageResoureID = R.drawable.lemon_squeeze,
                instruction = R.string.lemon_content_description,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0){
                        currentStep = 3
                    }
                }
            )
        }

        3 -> {
            LemonImageAndText(
                imageResoureID = R.drawable.lemon_drink,
                instruction = R.string.glass_of_lemonade_decription,
                onImageClick = {
                    currentStep = 4
                }
            )
        }

        4 -> {
            LemonImageAndText(
                imageResoureID = R.drawable.lemon_restart,
                instruction = R.string.Empty_glass_description,
                onImageClick = {
                    currentStep = 1
                }
            )
        }

    }
}

@Composable
fun LemonImageAndText(
    imageResoureID: Int,
    instruction: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(onClick = onImageClick) {
            Image(
                painter = painterResource(id = imageResoureID),
                contentDescription = stringResource(id = instruction),
            )

        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = instruction))


    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonImageAndText(
            imageResoureID = R.drawable.lemon_tree,
            instruction = R.string.lemon_tree_content_description,
            onImageClick = { /*TODO*/ })
    }
}