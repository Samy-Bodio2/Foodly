package com.example.foodly.screens.RestaurantDetail_Order

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.background
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(
                        onClick = { /* action lorsque l'on clique sur le bouton retour */ }
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                    Text(
                        text = "",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }
    ) {
        Text(
            text = "Big Garden Salad",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(10.dp)
        )

        Column(modifier = Modifier.padding(top = 48.dp)) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "4,8",fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Star, contentDescription = null, tint = Color.Yellow)
                            Icon(Icons.Filled.Star, contentDescription = null,tint = Color.Yellow)
                            Icon(Icons.Filled.Star, contentDescription = null,tint = Color.Yellow)
                            Icon(Icons.Filled.Star, contentDescription = null,tint = Color.Yellow)
                            Icon(Icons.Filled.Star, contentDescription = null,tint = Color.Yellow)
                        }
                    }
                    //ProgressBar
                    Column() {
                        Row() {
                            Text(text = "5", Modifier.offset(20.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .padding(start = 30.dp, end = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                //.background(Color.Gray)
                                .shadow(
                                    2.dp,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(12.dp)
                                )
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .padding(end = 20.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Green)
                                ){}
                            }
                        }
                        Row() {
                            Text(text = "4", Modifier.offset(20.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .padding(start = 30.dp, end = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                //.background(Color.Gray)
                                .shadow(
                                    2.dp,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(12.dp)
                                )
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .padding(end = 70.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Green)
                                ){}
                            }
                        }
                        Row() {
                            Text(text = "3", Modifier.offset(20.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .padding(start = 30.dp, end = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                //.background(Color.Gray)
                                .shadow(
                                    2.dp,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(12.dp)
                                )
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .padding(end = 165.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Green)
                                ){}
                            }
                        }
                        Row() {
                            Text(text = "2", Modifier.offset(20.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .padding(start = 30.dp, end = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                //.background(Color.Gray)
                                .shadow(
                                    2.dp,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(12.dp)
                                )
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .padding(end = 155.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Green)
                                ){}
                            }
                        }
                        Row() {
                            Text(text = "1", Modifier.offset(20.dp))
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .padding(start = 30.dp, end = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                //.background(Color.Gray)
                                .shadow(
                                    2.dp,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(12.dp)
                                )
                            ){
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .padding(end = 170.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Green)
                                ){}
                            }
                        }
                    }





                }
            }
        }
        //Overview

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp, end = 260.dp), contentAlignment = Alignment.Center){
            Text(text = "OverView",fontWeight = FontWeight.Bold, fontSize = 20.sp,  color = Color.Black)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 240.dp, end = 10.dp)
        ) {
            Row() {
                Text(text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eos iste eius accusantium voluptatibus, at officia ut inventore animi eum! Quo neque ipsum voluptas saepe aliquam distinctio natus exercitationem nobis a. Read more ")
                //Text(text = "Read more", color = Color.Green, modifier = Modifier.offset(x = 10.dp, y = 10.dp))
                Text(text = "Read more", color = Color.Green)
            }

        }

        Box(){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 330.dp, end = 10.dp)){
                Text(text = "Monday-Friday              : 10:00-22.00",fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 380.dp, end = 10.dp)){
                Text(text = "Saturday-Sunday             : 12:00-20.00",fontWeight = FontWeight.Bold)
            }
        }

    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 500.dp, end = 300.dp), contentAlignment = Alignment.Center){
        Text(text = "Adresse",fontWeight = FontWeight.Bold, fontSize = 20.sp,  color = Color.Black)
    }
}

/*
@Composable
fun MyBox() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.LightGray
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Note")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, contentDescription = null)
                    Icon(Icons.Filled.Star, contentDescription = null)
                    Icon(Icons.Filled.Star, contentDescription = null)
                    Icon(Icons.Filled.Star, contentDescription = null)
                    Icon(Icons.Filled.Star, contentDescription = null)
                }
            }
            Column(modifier = Modifier.width(120.dp)) {
                Text(text = "Progression")
                LinearProgressIndicator(progress = 0.5f)
                LinearProgressIndicator(progress = 0.8f)
                LinearProgressIndicator(progress = 0.3f)
            }
        }
    }
}*/

@Preview
@Composable
fun MyScreenPreview() {
    MyScreen()

    //MyBox()
}