package com.example.foodly.screens.RestaurantDetail_Order

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AddMenu() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.food),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 400.dp)
                .align(Alignment.TopCenter)
        )

        IconButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /* Do something */ },
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "+")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "1",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.widthIn(max = 40.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { /* Do something */ },
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "-")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = "",
                onValueChange = { /* Do something */ },
                placeholder = { Text(text = "Note to Restaurant (optional)") },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Do something */ },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    LightGreen,
                    contentColor = Color.White
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Add to Basket - $12.00")
            }
        }
    }
}

@Preview
@Composable
fun PreviewPlaceOrderScreen(){
    AddMenu()
}