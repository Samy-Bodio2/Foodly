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
import com.example.foodly.R
import com.example.foodly.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMenu() {
    Column {
        TopAppBar(
            title = { Text(text = "Mixed Vegetable Salab") },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
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
                .height(250.dp),
            contentScale = ContentScale.FillBounds
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(110.dp)
                .height(40.dp)
                .clip(shape = CircleShape)
                .background(LightGreen3)
        ) {
<<<<<<< HEAD
            Spacer(modifier = Modifier.width(100.dp))
=======
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        IconButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send"
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 240.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {
            Text(
                text = "Mixed Vegetable Salad",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tortor nisi, porttitor at ex nec, convallis viverra orci.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

>>>>>>> e9b9c94a81fa1ba4cf7b8ef76313f5dc419e2b49
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(colorWhite)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        if(counter.value < 1){
                        counter.value == 1
                    }else{
                            counter.value--
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Minimize,
                            contentDescription = "",
                            tint = LightGreen,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }

                Text(
                    text = "${counter.value}",
                    color = colorBlack,
                    style = androidx.compose.material.MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

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
            }
        }

        TextField(
            value = "",
            onValueChange = { /* Do something */ },
            placeholder = { Text(text = "Note to Restaurant (optional)") },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { /*TODO*/ },
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
    AddMenu()
}

