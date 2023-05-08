package com.example.foodly.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import com.example.foodly.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodly.model.meals

import com.example.foodly.ui.theme.TestAppTheme

@Composable

fun FoodlyTheme (content: @Composable () -> Unit) {
    TestAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search Food,", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "", tint = Color.White)
        }
    }
}






@Composable
fun VerticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(5.dp)
            .height(32.dp)
    )
}
@Composable
fun MealList(navController: NavHostController) {
    Column {
        AppBar()
        Spacer(modifier = Modifier.weight(1f))
        BottomButton( navController
            // action à effectuer lors du clic sur le bouton
        )
    }
    var totalPrice by remember { mutableStateOf(0.0) }

    Column(modifier = Modifier.padding(16.dp)) {
        VerticalDivider()
        meals.forEach { meal ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.getstartmg),
                    contentDescription = meal.name,
                    modifier = Modifier.size(50.dp)
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(text = meal.name)
                    Text(text = "$${meal.price}")
                }
                Row(modifier = Modifier.padding(end = 8.dp)) {
                    Button(onClick = { meal.quantity-- }) {
                        Text("-")
                    }
                    TextField(
                        value = meal.quantity.toString(),
                        onValueChange = {
                            meal.quantity = it.toIntOrNull() ?: meal.quantity
                            totalPrice = meals.sumOf { m -> m.price * m.quantity }
                        },
                        modifier = Modifier.width(50.dp)
                    )
                    Button(onClick = { meal.quantity++ }) {
                        Text("+")
                    }
                    totalPrice += meal.price * meal.quantity
                }
            }
        }
        Text(text = "Total: $${totalPrice}",modifier = Modifier.padding(top = 16.dp))
    }

}
@Composable
fun BottomButton(navController : NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Button(
            onClick = {
                navController.navigate("login_page") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            modifier = Modifier.align(Alignment.Center)
                .padding(vertical = 8.dp)
                .heightIn(min = 48.dp, max = 72.dp)
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colors.primaryVariant)
                .clip(RoundedCornerShape(24.dp))
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp))
        ) {
            Text(
                text = "Commander",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 18.sp
            )
        }
    }
}

