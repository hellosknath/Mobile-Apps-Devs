package com.sriidea.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sriidea.myjetpack.ui.theme.MyJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExample3()
        }
    }
}

@Composable
fun BoxExample(){
    Box(modifier = Modifier
        .background(color = Color.Black)
        .size(180.dp, 300.dp)
    ){
        Box(modifier = Modifier
            .background(color = Color.White)
            .size(120.dp, 200.dp)
            .align(alignment = Alignment.Center)
        ){
            Text(text = "Hi", modifier = Modifier
                .align(alignment = Alignment.Center)
            )
        }
    }
}

@Composable
fun BoxExample2(){
    Box(modifier = Modifier
        .background(color = Color.DarkGray)
        .fillMaxSize()) {

        Text(style = MaterialTheme.typography.h6,
        modifier = Modifier
            .background(Color.Yellow)
            .padding(6.dp)
            .align(Alignment.TopCenter),
        text = "TopCenter")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.TopStart),
            text = "TopStart")


        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.TopEnd),
            text = "TopEnd")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.CenterStart),
            text = "CenterStart")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.Center),
            text = "Center")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.CenterEnd),
            text = "CenterEnd")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.BottomStart),
            text = "BottomStart")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.BottomCenter),
            text = "BottomCenter")

        Text(style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(6.dp)
                .align(Alignment.BottomEnd),
            text = "BottomEnd")

    }

}


@Composable
fun BoxExample3(){
    Box (){
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "images",
            Modifier
                .size(300.dp, 300.dp)
                .align(Alignment.TopCenter))
        Text(text = "Image",
            style = MaterialTheme.typography.h6,
        color = Color.Black,
        modifier = Modifier.align(Alignment.BottomCenter))

        Button(onClick = {},
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.White,
            contentColor = Color.DarkGray
        ),
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(10.dp)
            .border(3.dp, color = Color.DarkGray, RectangleShape)) {
Text(text = "Add To Cart")
        }
    }
}



