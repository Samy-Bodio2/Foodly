package com.example.foodly.screens.Orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PlaceOrderScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.food),
            contentDescription = "Mixed Vegetable Salad",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            IconButton(onClick = { /* Handle send button click */ }) {
                Icon(
                    Icons.Filled.Send,
                    contentDescription = "Send"
                )
            }
        }
        Text(
            text = "Mixed Vegetable Salad",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor mauris vel libero elementum, at molestie justo commodo. Morbi quis imperdiet velit, eu dignissim nisl.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = { /* Handle decrement button click */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "-")
            }
            Text(
                text = "2",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Button(
                onClick = { /* Handle increment button click */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "+")
            }
        }
        TextField(
            value = "",
            onValueChange = { /* Handle text field value change */ },
            placeholder = { Text(text = "Note to Restaurant (optional)") },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Button(
            onClick = { /* Handle add to basket button click */ },
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(LightGreen),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Add to basket - $12.00")
        }
    }
}

@Preview
@Composable
fun PreviewPlaceOrderScreen(){
    PlaceOrderScreen()
}