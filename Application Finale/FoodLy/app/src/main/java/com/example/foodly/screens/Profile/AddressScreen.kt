package com.example.foodly.screens.Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.size.Size
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.LightGreen2
import com.example.foodly.ui.theme.colorWhite
import com.example.foodly.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdresseScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Adress",fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },

        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 70.dp
                    )
            ) {
                Box(
                    modifier = Modifier

                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, Color.White),
                            RoundedCornerShape(50.dp)
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Column() {
                            Row() {
                                androidx.compose.material.Text(
                                    text = "Home",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.size(size = 12.dp))
                                androidx.compose.material.Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen2),
                                ) {
                                    androidx.compose.material.Text(
                                        text = "Default",
                                        color = Color.White
                                    )
                                }
                            }
                            androidx.compose.material.Text(
                                text = "Times Square,Douala,27",
                                fontSize = 18.sp
                            )

                        }
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "pencil",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier

                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, Color.White),
                            RoundedCornerShape(50.dp)
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Column() {
                            Row() {
                                androidx.compose.material.Text(
                                    text = "My Office",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            androidx.compose.material.Text(
                                text = "5256 Blue Bill Park. PC 4627",
                                fontSize = 18.sp
                            )

                        }
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "pencil",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier

                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, Color.White),
                            RoundedCornerShape(50.dp)
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Column() {
                            Row() {
                                androidx.compose.material.Text(
                                    text = "My Apartment",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            androidx.compose.material.Text(
                                text = "21833 Clyde Gallagher, PC 4662",
                                fontSize = 18.sp
                            )

                        }
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "pencil",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier

                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, Color.White),
                            RoundedCornerShape(50.dp)
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Column() {
                            Row() {
                                androidx.compose.material.Text(
                                    text = "Parent's House",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            androidx.compose.material.Text(
                                text = "6993 Meadow Valley Terra, PC 36",
                                fontSize = 18.sp
                            )

                        }
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "pencil",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier

                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, Color.White),
                            RoundedCornerShape(50.dp)
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Column() {
                            Row() {
                                androidx.compose.material.Text(
                                    text = "My Villa",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            androidx.compose.material.Text(
                                text = "61840 SunBrook Park, PC 5679",
                                fontSize = 18.sp
                            )

                        }
                        Spacer(modifier = Modifier.size(size = 20.dp))
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "pencil",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                }

                androidx.compose.material.Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        LightGreen2,
                        contentColor = LightGreen2
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(20.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    androidx.compose.material.Text(
                        text = "And new adress",
                        fontSize = 11.sp,
                        modifier = Modifier.padding(0.dp),
                        color = white,
                        maxLines = 1
                    )
                }
            }
        })
}




@Preview
@Composable
fun PreviewAdresse(){
    val navController = rememberNavController()
    AdresseScreen(navController)
}