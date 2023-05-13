package com.example.foodly.commander


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodly.ui.theme.orange2
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun OrderConfirmationScreen(navController : NavHostController) {
    val currentTime = SimpleDateFormat("dd/MM/yyyy ", Locale.getDefault()).format(Date())
    val current = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Icone de menu
                // Remplacez l'icône par celle de votre choix
                Column() {
                    Icon(imageVector = Icons.Default.Menu,contentDescription = "")

                    Spacer(modifier = Modifier.width(12.dp))

                    Text("Order Confirmation", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .shadow(elevation = 10.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                , contentAlignment = Alignment.Center

            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Food", style = MaterialTheme.typography.h4, color = Color.Gray)
                        Text("Ly", style = MaterialTheme.typography.h4, color = orange2)
                        Spacer(modifier = Modifier.weight(1f))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(currentTime, modifier = Modifier.align(Alignment.Start))
                            Text(current, modifier = Modifier.align(Alignment.End))
                        }
                    }
                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        "Douala Planet",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Row {
                        Text(
                            "Order Number",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(113.dp))

                        Text("69028472", style = MaterialTheme.typography.subtitle1)
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                    Row {
                        Text(
                            "Delivery Time",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(113.dp))
                        Text("60 mins", style = MaterialTheme.typography.subtitle1)
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                    Row {
                        Text(
                            "Payment Method",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(113.dp))
                        Text("Cash", style = MaterialTheme.typography.subtitle1)
                    }

                    Spacer(modifier = Modifier.height(70.dp))

                    Row {
                        repeat(100) {
                            Text("•", style = MaterialTheme.typography.body2)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Text(
                            "TOTAL:",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(113.dp))
                        Text(
                            "FCFA 70.00",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                            color = orange2
                        )
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .background(Color.White)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick =  {

                        navController.navigate("track") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    } ,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 2.dp, color = White),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .background(Color.White)
                ) {
                    // Placer le texte dans le contenu du bouton
                    Text(
                        text = "Track your order",
                        style = MaterialTheme.typography.button,
                        color = orange2,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick =  {

                        navController.navigate("homescreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    } ,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 2.dp, color = orange2),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .background(orange2)
                ) {
                    Text(
                        "Home",
                        style = MaterialTheme.typography.button,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp)
                    )
                }
            }
        }
    }
}
