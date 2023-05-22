package com.example.foodly.screens.Home_ActionMenu

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.utils.read
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(navController)
        },
        content = {
            LazyColumn{
                item {
                    Content(navController)
                    Spacer(Modifier.size(20.dp))
                }

                item{
                    lazyItems()
                }
            }




        }
    )
}

@Composable
fun AppBar(navController : NavController){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ){
        BoxWithRes(resId = R.drawable.baseline_account_circle_24, description = "Person")
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Times Square", Modifier.size(10.dp), fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.width(36.dp))
            IconButton(onClick = {  }) {
                Icon(Icons.Filled.Notifications, contentDescription = "Notification")
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { navController.navigate(Screen.ShoppingCard.route) }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Shopping Cart")
            }
        }
    }
}

@Composable
fun Content(navController: NavController){

    Column{

        Header()
        Spacer(modifier = Modifier.width(16.dp))
        PromotionSection(navController)
        Spacer(modifier = Modifier.width(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.width(16.dp))
        DiscountSection()
        Spacer(modifier = Modifier.width(16.dp))
        Recommended()
        Spacer(modifier = Modifier.width(16.dp))
        ChipSection(chips = listOf("All","Hamburger","Pizza","Drink","Cake"))
        Spacer(modifier = Modifier.width(16.dp))
    }
}






@Composable
fun lazyItems(){
    val list by remember { mutableStateOf(read()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        list.forEach {  item ->

            item?.let {
                MenuList(
                    url = it.Image,
                    titre = it.name,
                    restauName = it.restaurant_name,
                    price = it.price
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
@Composable
fun Header(){
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
            label = { Text(text = "What are you craying?", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
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
    }
}

@Composable
fun PromotionSection(navController: NavController){
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Special Offers", style = MaterialTheme.typography.h6)
            TextButton(onClick = {navController.navigate(Screen.CategoryScreen.route)}) {
                Text(text = "See All", color = LightGreen)
            }
        }
    }
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.bhb),
                title = "30%",
                subtitle = "Discount Only",
                header = "Valid for today",
                backgroundColor = Color.Green
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(380.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 34.sp, color = Color.White)
                Text(text = subtitle, fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CategorySection(){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButton(
            text = "Tacos",
            icon = painterResource(id = R.drawable.tacos),
            backgroundColor = Color(0xffFEF4E7)
        )
        CategoryButton(
            text = "Vegetables",
            icon = painterResource(id = R.drawable.ic_veg),
            backgroundColor = Color(0xffF6FBF3)
        )
        CategoryButton(
            text = "Pizza",
            icon = painterResource(id = R.drawable.pizzas),
            backgroundColor = Color(0xffFFFBF3)
        )
        CategoryButton(
            text = "Hamburger",
            icon = painterResource(id = R.drawable.burgers),
            backgroundColor = Color(0xffF6E6E9)
        )
    }
    Spacer(modifier = Modifier.width(4.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButton(
            text = "Drink",
            icon = painterResource(id = R.drawable.drink),
            backgroundColor = Color(0xffFEF4E7)
        )
        CategoryButton(
            text = "Beer",
            icon = painterResource(id = R.drawable.beer),
            backgroundColor = Color(0xffF6FBF3)
        )
        CategoryButton(
            text = "Poulet",
            icon = painterResource(id = R.drawable.pane),
            backgroundColor = Color(0xffFFFBF3)
        )
        CategoryButton(
            text = "Cheese",
            icon = painterResource(id = R.drawable.cheese),
            backgroundColor = Color(0xffF6E6E9)
        )
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun DiscountSection(){
    val MenuItemss by remember { mutableStateOf(read()) }



    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Discount Guaranteed", style = MaterialTheme.typography.h6)
        TextButton(onClick = {}) {
            Text(text = "See All", color = LightGreen)
        }
    }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MenuItemss.forEachIndexed { index, item ->
                MenuItemss[index]?.let {
                    DiscountSectionItems(it.Image, it.name, it.restaurant_name, it.price)
                }
            }
        }






    }
}

/*
            MenuItemss[index]?.let {
                Text(text = it.name,
                    Modifier
                        .width(100.dp)
                        .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        .padding(10.dp)
                    , textAlign = TextAlign.Center)
            }
            MenuItemss[index]?.Image?.let {
                MyImage(url = it)
            }*/


data class MenuItem(
    val Confirmed: Boolean,
    val Image: String,
    val date: String,
    val name: String,
    val price: Double,
    val quantity : Double,
    val restaurant_name : String
){
    constructor() : this(false,"","", "",0.0,0.0,"")
}

@Composable
fun DiscountSectionItems(url: String,titre:String,restauName:String="",price: Double=0.0){
    val imagePainter: Painter = rememberImagePainter(url)

    Spacer(modifier = Modifier.padding(10.dp))
    DiscountSectionItem(
        imagePainter = imagePainter,
        title = titre,
        headers = restauName,
        price = price.toString()

    )
}

@Composable
fun DiscountSectionItem(
    title: String = "",
    headers: String ="",
    price: String = "",
    imagePainter: Painter
){
    Card(
        Modifier
            .width(160.dp)
    ){
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ){
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ){
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = headers,  color = Color.Black, fontWeight = FontWeight.Bold)
                Row{
                    Text(text = "$${price}")
                }
            }
        }
    }
}

@Composable
fun Recommended(){
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Recommended For You", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "See All", color = LightGreen)
            }
        }
    }
}

@Composable
fun ChipSection(chips: List<String>){
    var selectedChipIndex by remember{
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectedChipIndex == it) LightGreen
                    else Color.White
                )
                .padding(15.dp)
            ){
                Text(text = chips[it],color = Color.Black,fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun MenuList(url: String,titre:String,restauName:String,price: Double) {
    val imagePainter: Painter = rememberImagePainter(url)
    Row(
        Modifier.height(90.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){

        MenuItem(
            imagePainter = imagePainter,
            title = titre,
            subtitle = restauName,
            price = price.toString(),
            backgroundColor = Color.White
        )


    }

}

@Composable
fun MenuItem(title: String ,
             subtitle: String,
             price: String ,
             backgroundColor: Color ,
             imagePainter: Painter
){
    Card(
        Modifier.width(250.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ){
        Row{
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title,  color = Color.Black)
                Text(text = subtitle,  color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = price, color = Color.Black)
            }

        }
    }

}

@Composable
fun MenuList1() {
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            MenuItem1(
                imagePainter = painterResource(id = R.drawable.eru),
                title = "Water Fufu and Eru",
                subtitle = "1.7 km | 4.6 (1.3k)",
                price = "$2.50",
                backgroundColor = Color.White
            )
        }

    }

}
@Composable
fun MenuItem1(title: String = "",
              subtitle: String = "",
              price: String = "",
              backgroundColor: Color = Color.Transparent,
              imagePainter: Painter
){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ){
        Row{
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title,  color = Color.Black)
                Text(text = subtitle,  color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = price, color = Color.Black)
            }

        }
    }

}

@Composable
fun MenuList2() {
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            MenuItem2(
                imagePainter = painterResource(id = R.drawable.frite),
                title = "Frites sauce ketchun",
                subtitle = "1.4 km | 4.2 (1.4k)",
                price = "$2.00",
                backgroundColor = Color.White
            )
        }

    }

}
@Composable
fun MenuItem2(title: String = "",
              subtitle: String = "",
              price: String = "",
              backgroundColor: Color = Color.Transparent,
              imagePainter: Painter
){
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ){
        Row{
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title,  color = Color.Black)
                Text(text = subtitle,  color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = price, color = Color.Black)
            }

        }
    }

}



@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = Color.White,
    iconColor: Color? = Color.Black,
    boxSize: Int? = 40,
    iconSize: Int = 24

) {

    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bgColor!!), contentAlignment = Alignment.Center
    )
    {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(iconSize.dp),
            tint = iconColor!!
        )
    }

}