package com.example.foodly.screens.Home_ActionMenu

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.model.*
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.Gra
import com.example.foodly.utils.read
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.foodly.ui.theme.LightGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {
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
            Text(text = "Times Square")
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

    var selectedCategories by remember { mutableStateOf(emptyList<Categories>()) }

    Column{

        Header()
        Spacer(modifier = Modifier.width(16.dp))
        PromotionSection(navController)
        Spacer(modifier = Modifier.width(16.dp))
        CategorySection(onCategoryClick = { selectedCategories = it  })
        Spacer(modifier = Modifier.width(16.dp))
        //DiscountSection(navController)
        CategoryList(categories = selectedCategories, navController)
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
            val iconBox by remember { mutableStateOf(false) }
            item?.let {
                MenuList(
                    inPanier = it.Confirmed,
                    url = it.Image,
                    titre = it.name,
                    restauName = it.restaurant_name,
                    price = it.price,
                    iconBox
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
                backgroundColor = LightGreen
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
fun CategorySection(onCategoryClick: (List<Categories>) -> Unit){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffFEF4E7),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(tacos) }
        ) {
            Image(painter = painterResource(id = R.drawable.tacos), contentDescription = "", modifier = Modifier.fillMaxSize())
        }
            Text(text = "Tacos", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }

        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffF6FBF3),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(vegetarian) }
            ) {
                Image(painter = painterResource(id = R.drawable.ic_veg), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Vegetables", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }


        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffFFFBF3),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(pizza) }
            ) {
                Image(painter = painterResource(id = R.drawable.pizzas), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Pizza", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }


        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffF6E6E9),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(meat) }
            ) {
                Image(painter = painterResource(id = R.drawable.burgers), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Meat", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }

    }
    Spacer(modifier = Modifier.width(4.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffFEF4E7),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(alcohol) }
            ) {
                Image(painter = painterResource(id = R.drawable.beer), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Alcohol", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }


        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffF6FBF3),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(traditional) }
            ) {
                Image(painter = painterResource(id = R.drawable.traditionnal), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Traditionnal", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }


        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffFFFBF3),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(chicken) }
            ) {
                Image(painter = painterResource(id = R.drawable.pane), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Chicken", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }

        Column(
            Modifier
                .width(72.dp)
                .clickable { }
        ){
            Box(
                Modifier
                    .size(72.dp)
                    .background(
                        color = Color(0xffF6E6E9),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(18.dp)
                    .clickable { onCategoryClick(drinks) }
            ) {
                Image(painter = painterResource(id = R.drawable.drink), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
            Text(text = "Drinks", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
        }
    }
}

@Composable
fun CategoryList(categories: List<Categories>, navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Discount Guaranteed", style = MaterialTheme.typography.h6)
        TextButton(onClick = {navController.navigate(Screen.RestaurantScreen.route)}) {
            Text(text = "View Restaurant", color = LightGreen)
        }
    }
    LazyRow(Modifier.fillMaxWidth()) {
        items(categories) { category ->
            Card(
                Modifier.padding(8.dp),
                elevation = 4.dp,
                backgroundColor = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(20.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = category.image),
                        contentDescription = null,
                        Modifier
                            .height(150.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )
                    Column(Modifier.padding(8.dp)) {
                        Text(category.name, style = MaterialTheme.typography.h6)
                        Text("Restaurant: ${category.restaurantName}")
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color,
    onCategoryClick: MutableState<MutableList<Categories?>>
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
                .clickable { onCategoryClick }
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun DiscountSection(navController: NavController){
    val MenuItemss by remember { mutableStateOf(read()) }



    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Discount Guaranteed", style = MaterialTheme.typography.h6)
        TextButton(onClick = {navController.navigate(Screen.RestaurantScreen.route)}) {
            Text(text = "View Restaurant", color = LightGreen)
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
data class MenuItem(
    val Confirmed: Boolean,
    val Image: String,
    val date: String,
    val name: String,
    val price: Double,
    val quantity : Int,
    var quantiteCom : Int,
    val restaurant_name : String
){
    constructor() : this(false,"","", "",0.0,1,1,"")
}

@Composable
fun DiscountSectionItems(
    url: String,
    titre:String,
    restauName:String="",
    price: Double=0.0
){
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
            .clickable(onClick = { })
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
                    Text(text = "${price} FCFA")
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
fun MenuList(inPanier: Boolean,url: String,titre:String,restauName:String,price: Double,iconB: Boolean) {
    val imagePainter: Painter = rememberImagePainter(url)
    Column(
        Modifier.height(90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        MenuItem(
            inPanier = inPanier,
            imagePainter = imagePainter,
            title = titre,
            subtitle = restauName,
            price = price.toString(),
            backgroundColor = Color.White,
            iconB = iconB
        )


    }

}
@Composable
fun MenuItem(
    inPanier: Boolean,
    title: String ,
    subtitle: String,
    price: String ,
    backgroundColor: Color ,
    imagePainter: Painter,
    iconB: Boolean = false
) {
    var iconB by remember { mutableStateOf(inPanier) }
    var icon = if (!iconB) {

        Icons.Default.Add

    } else {

        Icons.Default.Check

    }
    val navController = rememberNavController()
    Card(
        Modifier
            .width(250.dp)
            .height(300.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp,
    ) {
        Row() {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                IconButton(onClick = {
                    // j'aimerais un code qui me permet de faire exactement la meme chose que celui si mais au lieu d'entrer l'identifiant du document manuellement j'entre la valeur du champ menu correspondant au document :"@Composable

                    val db = Firebase.firestore
                    val menuRef = db.collection("Menu")

                    menuRef.whereEqualTo("name", title)
                        .get()
                        .addOnSuccessListener { querySnapshot ->
                            for (document in querySnapshot.documents)
                            {
                                val confirm = document.getBoolean("Confirmed")!!
                                val documentRef = menuRef.document(document.id)
                                val collectionUpdate = mapOf("Confirmed" to !confirm)
                                documentRef.update(collectionUpdate)
                            }
                        }

                    iconB = !iconB
                }) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(LightGreen)
                    ){
                        Icon(imageVector = icon, contentDescription = "", tint = Color.White)
                    }
                }
                Row{
                    Text(text = title, color = Color.Black)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = price, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = subtitle, color = Color.Black, fontWeight = FontWeight.Bold)


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

@Preview
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    HomeScreen(navController)
}