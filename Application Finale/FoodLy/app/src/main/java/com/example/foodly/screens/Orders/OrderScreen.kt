package com.example.foodly.screens.Orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.LightGreen2

@Composable
fun OrderScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Orders") },
            backgroundColor = Color.White,
            navigationIcon = { IconButton(onClick = { /* Do Something */ }) {
                Icon(Icons.Filled.ShoppingCartCheckout, contentDescription = "Search")
            } },
            actions = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Do Something */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            },
            elevation = 0.dp
        )
        OrderCategoryTab(navController)
    }
}

@Composable
fun OrderCategoryTab(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val categories = listOf("Active", "Completed", "Cancelled")
    val colors = listOf(
        LightGreen,
        LightGreen,
        LightGreen
    )

    TabRow(selectedTabIndex = selectedIndex, backgroundColor = White) {
        categories.forEachIndexed { index, category ->
            Tab(
                text = { Text(text = category, color = if (index == selectedIndex) colors[index] else Color.Gray) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                selectedContentColor = LightGreen,
                unselectedContentColor = LightGreen,

            )
        }
    }

    when (selectedIndex) {
        0 -> ActiveOrders()
        1 -> CompletedOrders()
        2 -> CancelledOrders(navController)
    }
}

@Composable
fun ActiveOrders() {
    Column {
        OrderItem(status = "Active", backgroundColor = Color.White) {
            // Handle Cancel button click
        }
        SortButton()
        Spacer(modifier = Modifier.height(16.dp))
        OrderItem(status = "Active", backgroundColor = Color.White) {
            // Handle Cancel button click
        }
        SortButton()
    }
}

@Composable
fun CompletedOrders() {
    Column {
        OrderItem(status = "Completed", backgroundColor = Color.White) {
            // Handle View Receipt button click
        }
        SortButton()

        Spacer(modifier = Modifier.height(16.dp))
        OrderItem(status = "Completed", backgroundColor = Color.White) {
            // Handle View Receipt button click
        }
        SortButton()

    }
}

@Composable
fun CancelledOrders(navController: NavController) {
    Column {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = White,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clickable {}
                .padding(vertical = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberImagePainter(R.drawable.okok),
                    contentDescription = "Sandwich image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Bite Me Sandwiches")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "3 items | 1.4km ")
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "XAF3500")
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = { navController.navigate(Screen.CancelOrder.route) },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Text(text = "Cancelled", color = LightGreen)
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = White,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clickable {}
                .padding(vertical = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberImagePainter(R.drawable.okok),
                    contentDescription = "Sandwich image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Bite Me Sandwiches")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "3 items | 1.4km ")
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "XAF3500")
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = { navController.navigate(Screen.CancelOrder.route) },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Text(text = "Cancelled", color = LightGreen)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OrderItems(status: String, backgroundColor: Color, onButtonClick: () -> Unit) {
    val navController = rememberNavController()
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable(onClick = onButtonClick)
            .padding(vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(R.drawable.okok),
                contentDescription = "Sandwich image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = "Bite Me Sandwiches")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "3 items | 1.4km ")
                Spacer(modifier = Modifier.height(5.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "XAF3500")
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {navController.navigate(Screen.CancelOrder.route)},
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Text(text = status, color = LightGreen)
                    }
                }
            }
        }
    }
}

@Composable
fun OrderItem(status: String, backgroundColor: Color, onButtonClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable(onClick = onButtonClick)
            .padding(vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(R.drawable.okok),
                contentDescription = "Sandwich image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = "Bite Me Sandwiches")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "3 items | 1.4km ")
                Spacer(modifier = Modifier.height(5.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "XAF3500")
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = onButtonClick,
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Text(text = status, color = LightGreen)
                    }
                }
            }
        }
    }
}


@Composable
fun TopAppbare(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {

            Image(
                painter = painterResource(R.drawable.foodlylogo),
                contentDescription = "Logo",
                modifier = Modifier

                    .height(20.dp)
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Orders", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Box(modifier = Modifier
            .height(20.dp)
            .width(20.dp), contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(R.drawable.search),
                contentDescription = "Logo",
                modifier = Modifier

                    .height(20.dp)
            )
        }

    }
}



/*
@Composable
fun OrderScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Orders") },
            backgroundColor = Color.White,
            navigationIcon = { IconButton(onClick = { /* Do Something */ }) {
                Image(
                    painter = painterResource(R.drawable.foodlylogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(20.dp)
                )
            } },
            actions = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Do Something */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            },
            elevation = 0.dp
        )
        OrderCategoryTab()
    }
}

@Composable
fun OrderCategoryTab() {
    var selectedIndex by remember { mutableStateOf(0) }
    val categories = listOf("Active", "Completed", "Cancelled")
    val colors = listOf(
        LightGreen,
        LightGreen,
        LightGreen
    )

    TabRow(selectedTabIndex = selectedIndex, backgroundColor = White) {
        categories.forEachIndexed { index, category ->
            Tab(
                text = { Text(text = category, color = if (index == selectedIndex) colors[index] else Color.Gray) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                selectedContentColor = LightGreen,
                unselectedContentColor =LightGreen ,

                )
        }
    }

    when (selectedIndex) {
        0 -> ActiveOrders()
        1 -> CompletedOrders()
        2 -> CancelledOrders()
    }
}

@Composable
fun ActiveOrders() {
    Column {
        Content()

        }

    }


@Composable
fun CompletedOrders() {
    Column {
        Content()
    }
}

@Composable
fun CancelledOrders() {
    Column {
        Content()
    }
}

//menu
@Composable
fun Content(){
    Column{
        Card( modifier = Modifier
            .padding(start = 20.dp, top = 15.dp)
            .width(320.dp)
            .height(170.dp),
            shape = RoundedCornerShape(8.dp),
            backgroundColor =Color.White){
            Menu()
            Spacer(modifier = Modifier.height(100.dp) .padding(top = 40.dp))
            SortButton()
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card( modifier = Modifier
            .padding(start = 20.dp)
            .width(320.dp)
            .height(170.dp) ,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White){
            Menu2()
            Spacer(modifier = Modifier.height(100.dp) .padding(top = 50.dp))
            SortButton()
        }
        Spacer(modifier = Modifier.height(20.dp) )
        Card(modifier = Modifier
            .padding(start = 20.dp)
            .width(310.dp)
            .height(110.dp) ,
            shape = RoundedCornerShape(8.dp),
            backgroundColor =Color.White){
            Menu3()

        }

    }
}


@Composable
fun Menu(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem(
                imagePainter = painterResource(id = R.drawable.im1),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun Menu2(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem2(
                imagePainter = painterResource(id = R.drawable.images2),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun Menu3(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem3(
                imagePainter = painterResource(id = R.drawable.im3),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun MenuItem(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(

        Modifier

            .padding(top = 10.dp)
            .width(315.dp)
            .height(100.dp) ,


        ) {
        Row {
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .height(150.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)

                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}", fontWeight = FontWeight.Bold,modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}", modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", color =LightGreen,fontWeight = FontWeight.Bold,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp,),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", modifier = Modifier .padding(bottom = 1.dp) .offset(y =3.dp),textAlign = TextAlign.Center)

                    }



                }

            }
        }
    }
}

@Composable
fun MenuItem2(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .width(315.dp)
            .height(100.dp) ,

        ) {
        Row {
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .fillMaxSize()
                        .height(500.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}", fontWeight = FontWeight.Bold, modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}",modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", color = LightGreen ,fontWeight = FontWeight.Bold ,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),

                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", fontWeight = FontWeight.Bold, modifier = Modifier, textAlign = TextAlign.Center )

                    }


                }


            }


        }

    }

}

@Composable
fun MenuItem3(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(
        Modifier
            .padding(top = 10.dp)
            .width(315.dp)
            .height(90.dp) ,
    ) {
        Row (modifier = Modifier .height(400.dp)){
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .height(500.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}" ,fontWeight = FontWeight.Bold , modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}", modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", fontWeight = FontWeight.Bold,color = LightGreen,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", fontWeight = FontWeight.Bold, modifier = Modifier .padding(bottom = 3.dp), textAlign = TextAlign.Center)

                    }
                }
            }
        }
    }
}

<<<<<<< HEAD
//btn
*/
@Composable
fun SortButton(){
    Row(
        modifier = Modifier
            .padding(17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = LightGreen
            ),
            border = BorderStroke(2.dp, LightGreen),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = Modifier.width(4.dp))
                Text("Leave a Review", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LightGreen,
                contentColor = Color.White
            ),
            border = BorderStroke(2.dp, LightGreen),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(4.dp))
                Text("Order Again", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }
    }


}

@Preview
@Composable
fun  OrderScreens(){
    val navController = rememberNavController()
    OrderScreen(navController)
}
