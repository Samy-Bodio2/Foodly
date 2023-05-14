package com.example.foodly.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.ui.theme.colorBlack

@Composable
fun TopAppBarMyOrders(navController: NavController) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            navController.navigate("homescreen") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "",
                tint = colorBlack
            )

        }

        Text(
            text = "Shopping Card \uD83D\uDE0B",
            color = colorBlack,
            style = MaterialTheme.typography.button,
            modifier = Modifier.padding(start = 100.dp)
        )
    }
}


