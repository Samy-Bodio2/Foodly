package com.example.foodly.screens.RestaurantDetail_Order

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.*


@Suppress("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DeliverTo(navController: NavController){
    var isChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar( backgroundColor = white,
                navigationIcon = {
                    IconButton(onClick = {
                       navController.navigate(Screen.CheckOutOrder.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.Black,
                            contentDescription = "Retour"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Deliver To",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .background(color = md_theme_light_onPrimary)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 0}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen2,
                            modifier = Modifier
                                .size(38.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Home",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.size(size = 12.dp))
                                Button(
                                    onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                    modifier = Modifier
                                        .width(67.dp)
                                        .height(35.dp)
                                ) {
                                    Text(
                                        text = "Default",
                                        color = LightGreen2,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Times Square, Douala, 27, Cameroun, Afrique",
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 0,
                            onClick = { selectedOption = 0 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = LightGreen
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 1}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen2,
                            modifier = Modifier
                                .size(38.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "My Office",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "5259,Douala,Rue desespoir, Cameroun, Afrique",
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 1,
                            onClick = { selectedOption = 1 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = LightGreen
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 2}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen2,
                            modifier = Modifier
                                .size(38.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "My Appartment",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Bonamoussadi, Douala, 27, Cameroun, Afrique",
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 2,
                            onClick = { selectedOption = 2 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = LightGreen
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 3}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen2,
                            modifier = Modifier
                                .size(38.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Parent's House",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Hilton Hotel, Douala, 27, Cameroun, Afrique",
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 3,
                            onClick = { selectedOption = 3 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = LightGreen
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 4}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = LightGreen2,
                            modifier = Modifier
                                .size(38.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "My Villa",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Times Square, Douala, 27, Cameroun, Afrique",
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 4,
                            onClick = { selectedOption = 4 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = LightGreen
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(7.dp))
                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        LightGreen3,
                        contentColor = LightGreen3
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(20.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "Add New Address",
                        fontSize = 11.sp,
                        modifier = Modifier.padding( 0.dp),
                        color = LightGreen,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.height(13.dp))
                Button(
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
                    Text(
                        text = "Apply",
                        fontSize = 11.sp,
                        modifier = Modifier.padding( 0.dp),
                        color = white,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

