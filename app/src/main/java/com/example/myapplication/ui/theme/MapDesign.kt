package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Preview
@Composable
fun DesignMap(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
            ) {
            Spacer(modifier = Modifier.size(5.dp))
            Surface(modifier = Modifier
                .height(150.dp)
                .width(350.dp)
                .padding(horizontal = 50.dp)){
                Image(
                    painter = painterResource(id = R.drawable.undraw_delivery_truck_vt6p),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

        }
    }
}