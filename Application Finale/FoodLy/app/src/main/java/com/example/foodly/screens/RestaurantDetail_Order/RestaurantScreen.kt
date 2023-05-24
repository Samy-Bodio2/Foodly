package com.example.foodly.screens.RestaurantDetail_Order

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen


@Composable
fun RestaurantScreen(navController: NavController){
    Box(
        Modifier.verticalScroll(rememberScrollState())
    ){
        Column {
            TopBar(navController)
            Content(navController)

        }
    }
}

@Composable
fun Content(navController: NavController){
    Column {
        ForYou(navController)
        Spacer(modifier = Modifier.height(20.dp))

        Menus()
        Spacer(modifier = Modifier.height(20.dp))
        Menu()

        Spacer(modifier = Modifier.height(20.dp))
        Menu1()
        Spacer(modifier = Modifier.height(20.dp))
        Menu2()

        Spacer(modifier = Modifier.height(20.dp))
        Drinks()
        Spacer(modifier = Modifier.height(20.dp))
        Drink()
        Spacer(modifier = Modifier.height(20.dp))
        Drink1()
    }
}


@Composable
fun TopBar(navController : NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.food1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            //  modifier = Modifier.fillMaxSize(),
            modifier = Modifier.aspectRatio(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Handle send button click */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Filled.Send, contentDescription = "Send", tint = Color.White)
        }
        // colonne des infos

        /*  Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
               // Icon(Icons.Filled.ArrowForward, contentDescription = "Arr")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Big Garden Salad", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Star, contentDescription = "Notation")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "4.8")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.LocationOn, contentDescription = "Localisation")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "2,4 km")
            }
        } */
        //

        Column(modifier = Modifier.padding(top = 420.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier) {
                    Text(text = "Big Garden Salad", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
                Box(modifier = Modifier) {
                    IconButton(onClick = { navController.navigate(Screen.RestaurantDetailScreen.route) }) {
                        Icon(Icons.Filled.ChevronRight, contentDescription = null)
                    }
                }
            }
            //like
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier) {

                    Row(modifier = Modifier.padding(top = 12.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.etoile),
                            contentDescription = "Etoile"
                        )
                        Text(text = "4.8", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = "(4.8k reviews)", fontSize = 12.sp)

                    }

                }

                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_forward_i),
                        contentDescription = ""
                    )

                }
            }
            //localisation
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier) {
                    Row(modifier = Modifier.padding(top = 12.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = "Localisation"
                        )
                        Text(text = "2.4 km", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = "(Delivery now |  $2.00)", fontSize = 12.sp)

                    }

                }
                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_forward_i),
                        contentDescription = ""
                    )

                }

            }//fin localisation


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier) {

                    Row(modifier = Modifier.padding(top = 12.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.etoile),
                            contentDescription = "Etoile"
                        )
                        Text(
                            text = "Offers are available",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        //Text(text = "(4.8k reviews)", fontSize = 12.sp )

                    }

                }
                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_forward_i),
                        contentDescription = ""
                    )

                }

            }


        }

    }
}
// partie du scrool

@Composable
fun ForYou(navController: NavController){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "For You",fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = Modifier.size(80.dp))
        }
        ForYouItems(navController)
    }
}
@Composable
fun ForYouItems(navController: NavController){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            ForYouItem(
                imagePainter = painterResource(id = R.drawable.food1),
                title ="Mixed Vegetable salad",
                price = "$12.00",
                onButtonClick = {navController.navigate(Screen.AddMenu.route)}
            )
        }
        item{
            ForYouItem(
                imagePainter = painterResource(id = R.drawable.food),
                title ="Fruit & Spice Salad",
                price = "$10.00",
                onButtonClick = {navController.navigate(Screen.AddMenu.route)}
            )
        }
        item{
            ForYouItem(
                imagePainter = painterResource(id = R.drawable.food),
                title ="Mixed Vegetable salad",
                price = "$10.00",
                onButtonClick = {navController.navigate(Screen.AddMenu.route)}
            )
        }
    }
}

@Composable
fun ForYouItem(
    title: String="",
    price: String="",
    imagePainter: Painter,
    onButtonClick: () -> Unit
){
    val navController = rememberNavController()
    Box(
        Modifier
            .width(160.dp)
            .clickable(onClick = onButtonClick)
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier= Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = price)
            }
        }
    }
}


@Composable
fun Menus(){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Menu",fontWeight = FontWeight.Bold, fontSize = 25.sp)
        }

    }
}

@Composable
fun Drinks(){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Drinks",fontWeight = FontWeight.Bold, fontSize = 25.sp)
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
                imagePainter = painterResource(id = R.drawable.food),
                title= "Special Bound Salad",
                price = "$10.50",
                backgroundColor= Color.White
            )
        }
    }
}

@Composable
fun MenuItem(
    imagePainter: Painter,
    title: String ="",
    price: String="",
    backgroundColor: Color = Color.Transparent){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor= backgroundColor,
        elevation = 0.dp
    ) {
        Row{
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    //.weight(1f),
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
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier
                    .width(55.dp)
                    .height(26.dp)) {
                    Text(text = "New", fontSize = 10.sp,)
                }
                Text(text = title, color = Color.Black)
                Text(text = price, color = Color.Black)
            }
        }
    }
}

@Composable
fun Menu1(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem1(
                imagePainter = painterResource(id = R.drawable.food),
                title= "Special Bound Salad",
                price = "$10.50",
                backgroundColor= Color.White
            )
        }
    }
}



@Composable
fun MenuItem1(
    imagePainter: Painter,
    title: String ="",
    price: String="",
    backgroundColor: Color = Color.Transparent){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor= backgroundColor,
        elevation = 0.dp
    ) {
        Row{
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    //.weight(1f),
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
                Text(text = title, color = Color.Black)
                Text(text = price, color = Color.Black)
            }
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
                imagePainter = painterResource(id = R.drawable.food),
                title= "Special Bound Salad",
                price = "$10.50",
                backgroundColor= Color.White
            )
        }
    }
}

@Composable
fun MenuItem2(
    imagePainter: Painter,
    title: String ="",
    price: String="",
    backgroundColor: Color = Color.Transparent){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor= backgroundColor,
        elevation = 0.dp
    ) {
        Row{
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    //.weight(1f),
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
                Text(text = title, color = Color.Black)
                Text(text = price, color = Color.Black)
            }
        }
    }
}


// DRINKS
@Composable
fun Drink(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            DrinkItem(
                imagePainter = painterResource(id = R.drawable.juice),
                title= "French Avocado Juice" +
                        "",
                price = "$4.50",
                backgroundColor= Color.White
            )
        }
    }
}

@Composable
fun DrinkItem(
    imagePainter: Painter,
    title: String ="",
    price: String="",
    backgroundColor: Color = Color.Transparent){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor= backgroundColor,
        elevation = 0.dp
    ) {
        Row{
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    //.weight(1f),
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
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier
                    .width(60.dp)
                    .height(30.dp)) {
                    Text(text = "Promo", fontSize = 10.sp,)
                }
                Text(text = title, color = Color.Black)
                Text(text = price, color = Color.Black)
            }
        }
    }
}

@Composable
fun Drink1(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            DrinkItem1(
                imagePainter = painterResource(id = R.drawable.juice),
                title= "French Orange Juice",
                price = "$3.00",
                backgroundColor= Color.White
            )
        }
    }
}

@Composable
fun DrinkItem1(
    imagePainter: Painter,
    title: String ="",
    price: String="",
    backgroundColor: Color = Color.Transparent){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor= backgroundColor,
        elevation = 0.dp
    ) {
        Row{
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    //.weight(1f),
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
                Text(text = title, color = Color.Black)
                Text(text = price, color = Color.Black)
            }
        }
    }
}


// end DRINKS


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MenuScreen()
}*/



@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    val navController = rememberNavController()
    //TopBar()
    RestaurantScreen(navController)
}
