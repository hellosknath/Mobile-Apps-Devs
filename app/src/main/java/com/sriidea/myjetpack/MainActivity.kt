package com.sriidea.myjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
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
            Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
                ButtonDemo()
            }

        }
    }
}

@Composable
fun ButtonDemo(){
    val context = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Click this button", Toast.LENGTH_SHORT).show() }) {
        Text(text = "Add to Cart")
    }

    Button(enabled = false,
        onClick = { Toast.makeText(context, "Click this button", Toast.LENGTH_SHORT).show() }) {
        Text(text = "Add to Cart")
    }

    TextButton(onClick = { Toast.makeText(context, "Click this TextButton", Toast.LENGTH_SHORT).show() }) {
        Text(text = "TextButton")
    }

    OutlinedButton(onClick = { Toast.makeText(context, "Click this OutlinedButton", Toast.LENGTH_SHORT).show() }) {
        Text(text = "OutlinedButton")
    }

    IconButton(onClick = { Toast.makeText(context, "Click this IconButton", Toast.LENGTH_SHORT).show() }) {
        Icon(Icons.Default.Add, contentDescription = "Add",
        tint = Color.DarkGray,
        modifier = Modifier.size(50.dp))
    }

    Button(onClick = { Toast.makeText(context, "Click this Custom Button", Toast.LENGTH_SHORT).show() },
    contentPadding = PaddingValues(14.dp),
    border = BorderStroke(2.dp, color = Color.Black),
    colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.White,
        contentColor = Color.Black
    )) {
        Text(text = "Custom Button",
        style = MaterialTheme.typography.h5)
    }

    Button(onClick = { Toast.makeText(context, "Click this Custom Button", Toast.LENGTH_SHORT).show() },
        contentPadding = PaddingValues(14.dp),
        border = BorderStroke(2.dp, color = Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
    shape = CutCornerShape(8.dp)) {
        Text(text = "Custom Button",
            style = MaterialTheme.typography.h5)
    }

    Button(onClick = { Toast.makeText(context, "Click this Custom Button", Toast.LENGTH_SHORT).show() },
        contentPadding = PaddingValues(14.dp),
        border = BorderStroke(2.dp, color = Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
    shape = CircleShape,) {
        Text(text = "Custom Button",
            style = MaterialTheme.typography.h5)
    }

}
