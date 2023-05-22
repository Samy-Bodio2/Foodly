package com.example.foodly.screens.RestaurantDetail_Order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMenu(navController: NavController) {
    Column {
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Screen.RestaurantScreen.route) }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Send, contentDescription = null)
                }
            }
        )
        Image(
            painter = painterResource(R.drawable.food),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )
        
        Text(
            text = "Mixed Vegetable Salab",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tortor nisi, porttitor at ex nec, convallis viverra orci.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )


        val counter = remember { mutableStateOf(1) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(LightGreen2)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        if(counter.value < 2){
                        counter.value == 1
                    }else{
                            counter.value--
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Minimize,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${counter.value}",
                    color = colorBlack,
                    style = androidx.compose.material.MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(LightGreen)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        counter.value++
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = colorWhite,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }


        TextField(
            value = "",
            onValueChange = { /* Do something */ },
            placeholder = { Text(text = "Note to Restaurant (optional)") },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { navController.navigate(Screen.CheckOutOrder.route) },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(LightGreen)
        ) {
            Text(text = "Add to basket - $12.00")
        }
    }
}

@Preview
@Composable
fun PreviewPlaceOrderScreen(){
    val navController = rememberNavController()
    AddMenu(navController)
}

