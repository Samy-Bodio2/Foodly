package com.example.foodly.screens.Home_ActionMenu

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
<<<<<<< HEAD
import androidx.compose.foundation.lazy.items
=======
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
<<<<<<< HEAD
import com.example.foodly.read
=======
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
<<<<<<< HEAD
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar()
        },
        content = {
        LazyColumn{
            item {
                Content()
                Spacer(Modifier.size(20.dp))
            }

            item{
                lazyItems()
            }
        }




        }
    )
}
=======
fun HomeScreen(navController: NavController){
//    Box(){
//
//
//                AppBar()
//                Content()
//                //DiscountSection()
//
//        }
    Scaffold(
        topBar = {AppBar()},
        content = {
Box(Modifier.verticalScroll(rememberScrollState())){Content()}


        }
    )
    }


>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4

//    Scaffold(
//        topBar = {AppBar()},
//        content = {
//Box(Modifier.verticalScroll(rememberScrollState())){Content()}
//
//
//        }
//    )
  //  }



@Composable
// fonction d'entete qui va contenir la photo de l'utilisateur connecter ainsi que les boutons de notifications
// et d'ajout au panier
fun AppBar(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ){
        BoxWithRes(resId = R.drawable.baseline_account_circle_24, description = "Person")
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Times Square", Modifier.weight(1f), fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.width(36.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_notifications_24),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                contentDescription = "bag",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun Content(){

Column{

        Header()
        Spacer(modifier = Modifier.width(16.dp))
        PromotionSection()
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
// fonction est utiliser pour afficher la barre de recherche
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
// cette fonction est pour afficher le box de la promotion de nous menu
fun PromotionSection(){
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Special Offers", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "See All", color = Color.Green)
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
// cette fonction nous permet de declarer toute les variables qui seront prises pour afficher le resultat du
//boxs publicitaire tout en modifiant les polices d'ecriture, l'alignement et la facon donc les elements
//seront disposer
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(350.dp),
        shape = RoundedCornerShape(8.dp),
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
//cette fonction permet d'avoir un apercu des produits que nous avons dans nos restaurants
fun CategorySection(){
    Row(
        Modifier.fillMaxWidth(),
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
        Modifier.fillMaxWidth(),
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
// cette fonction permet de styler les elements present dans notre box categorie
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
<<<<<<< HEAD
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
                        Text(text = "See All", color = Color.Green)
                    }
                }
=======
    val context = LocalContext.current
    var MenuItemss = mutableStateListOf<MenuItem?>()
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    LaunchedEffect(Unit) {
        db.collection("Menu").get()
            .addOnSuccessListener { queryDocumentSnapshots ->
                if (!queryDocumentSnapshots.isEmpty) {
                    val list = queryDocumentSnapshots.documents
                    for (d in list) {
                        val c: MenuItem? = d.toObject(MenuItem::class.java)
                        MenuItemss.add(c)
                        Toast.makeText(
                            context,
                            "reussi",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                } else {
                    Toast.makeText(
                        context,
                        "No need  found create one",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }.addOnFailureListener {
                Toast.makeText(
                    context,
                    "fail to get the data",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
/*    LazyColumn(Modifier.fillMaxSize()){
        itemsIndexed(*/MenuItemss.forEachIndexed{
                index, item ->

//                MenuItemss[index]?.name?.let {
//                    Text(
//                        text = it,
//                        Modifier.width(100.dp)
//                            .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
//                            .clip(RoundedCornerShape(20.dp)).padding(10.dp),
//                        textAlign = TextAlign.Center
//                    )
//                }

//                MenuItemss[index]?.let {
//                    DiscountSectionItems(it.Image,it.name,it.restaurant_name,it.price)
//
//                }
                    Column {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Discount Guaranteed", style = MaterialTheme.typography.h6)
                            TextButton(onClick = {}) {
                                Text(text = "See All", color = Color.Green)
                            }
                        }
                        MenuItemss[index]?.let {
                            DiscountSectionItems(it.Image,it.name,it.restaurant_name,it.price)
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
<<<<<<< HEAD
fun DiscountSectionItems(url: String,titre:String,restauName:String="",price: Double=0.0){
    val imagePainter: Painter = rememberImagePainter(url)
=======
// cette fonction permet d'afficher les differents repas que nous proposons ainsi que leurs prix,leurs notes,
//le nombreux de personnes aimant ce plat ainsi que la distance vous separant du restaurant qui le propose
fun DiscountSectionItems(){
>>>>>>> 54d9f8e05d16c767646ee7286fef1fcb5e9adc80
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
<<<<<<< HEAD
        MenuItemss.forEachIndexed { index, item ->
            MenuItemss[index]?.let {
                DiscountSectionItems(it.Image, it.name, it.restaurant_name, it.price)
            }
        }
        }


//                MenuItemss[index]?.let {
//                    DiscountSectionItems(it.Image,it.name,it.restaurant_name,it.price)
//
//                }



        }
=======
            DiscountSectionItem(
                imagePainter = imagePainter,
                title = titre,
                headers = restauName,
                price = price.toString()

            )
        }
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
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

            DiscountSectionItem(
                imagePainter = imagePainter,
                title = titre,
                headers = restauName,
                price = price.toString()

            )
}

@Composable
//le style et la forme des boxs
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
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
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
                Text(text = "See All", color = Color.Green)
            }
        }
    }
}

@Composable
//cette fonction permet de creer une barre de menu navigable qui va permettre de consulter au clic les differents
//produits recommander
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
                    if (selectedChipIndex == it) Color.Green
                    else Color.White
                )
                .padding(15.dp)
            ){
                Text(text = chips[it],color = Color.Gray,fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
<<<<<<< HEAD
fun MenuList(url: String,titre:String,restauName:String,price: Double) {
    val imagePainter: Painter = rememberImagePainter(url)
    Row(
=======
// cette fonction va permetre de recuperer les informations de menu preenregistrer et les afficher dans les
// MenuItem ou box qui seront creer au prealable
fun MenuList() {
    LazyRow(
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
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