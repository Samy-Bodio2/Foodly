package com.example.foodly.screens.RestaurantDetail_Order

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.LightGreen2
import com.example.foodly.ui.theme.md_theme_light_onPrimary
import com.example.foodly.ui.theme.white
import com.example.foodly.model.CheckOutData
import com.example.foodly.navigation.Screen
import com.example.foodly.screens.Home_ActionMenu.calculPrice
import com.example.foodly.utils.readConfirmedMenus

val order = listOf(
    CheckOutData(
        name = "Mixed Vegetable Salad..",
        argent = "FCFA12000",
        chiffre = "1x",
        coverImage = R.drawable.ekwang
    ),
    CheckOutData(
        name = "Special Pasta Salad",
        argent = "FCFA8000",
        chiffre = "1x",
        coverImage = R.drawable.ekwang
    ),
    CheckOutData(
        name = "Fresh Avocate Juice",
        argent = "FCFA4000",
        chiffre = "1x",
        coverImage = R.drawable.ekwang
    ),)


@Suppress("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CheckOutOrders(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar( backgroundColor = white,
                navigationIcon = {
                    IconButton(onClick = {
//                        navController.navigate("EWalletScreen") {
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
                    }) {
                        IconButton(onClick = { navController.navigate(Screen.AddMenu.route) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                tint = Black,
                                contentDescription = "Retour",
                            )
                        }

                    }
                },
                title = {
                    Text(
                        text = "CheckOut Orders",
                        color = Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .background(color = md_theme_light_onPrimary)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Column {
                        Text(
                            text = "Deliver To",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Divider(
                            modifier = Modifier.padding(16.dp),
                            color = md_theme_light_onPrimary,
                            thickness = 1.dp
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            Icon(
                                Icons.Rounded.LocationOn,
                                contentDescription = "position",
                                tint = LightGreen2,
                                modifier = Modifier
                                    .size(48.dp)
                            )
                            Spacer(modifier = Modifier.size(size = 5.dp))
                            Column {
                                Row() {
                                    Text(
                                        text = "Home",
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.size(size = 12.dp))
                                    Button(
                                        onClick = { /*TODO*/ },
                                        shape = RoundedCornerShape(16.dp),
                                        colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                        modifier = Modifier
                                            .width(67.dp)
                                            .height(35.dp)
                                    ) {
                                        Text(
                                            text = "Default",
                                            color = LightGreen2,
                                            fontSize = 10.sp
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Times Square, Douala, 27, Cameroun, Afrique",
                                    fontSize = 12.sp
                                )
                            }
                            Spacer(modifier = Modifier.size(size = 20.dp))
                            IconButton(onClick = { navController.navigate(Screen.DeliverTo.route) }) {
                                Icon(
                                    Icons.Rounded.KeyboardArrowRight,
                                    contentDescription = "pencil",
                                    tint = LightGreen,
                                    modifier = Modifier
                                        .size(28.dp)
                                )
                            }

                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                /*
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(430.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Order Summary",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(60.dp))
                            Button(
                                onClick = { /* TODO */ },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color.White,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    text = "Add Items",
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(0.dp),
                                    color = LightGreen2,
                                    maxLines = 1
                                )
                            }
                        }
                        Divider(
                            modifier = Modifier.padding(16.dp),
                            color = md_theme_light_onPrimary,
                            thickness = 1.dp
                        )
                        CheckOutList(order)
                    }
                }*/
                Spacer(modifier = Modifier.height(30.dp))
                Payement(navController)
                Spacer(modifier = Modifier.height(30.dp))
                Total(navController)
            }
        }
    }
}
@Composable
fun Total(navController: NavController){
    var showDialog by remember { mutableStateOf(false) }
    val list by remember { mutableStateOf(readConfirmedMenus()) }
    var totalPrice  by remember { mutableStateOf(0.0)}// Create a variable to hold the total price
    totalPrice = calculPrice(list)
    var deliver = 1000
    val somme = deliver + totalPrice
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(
                color = white,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ){
        Column(){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)){
                Text(
                    text = "SubTotal",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$totalPrice FCFA",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    color = Black
                )
            }
            Spacer(modifier = Modifier.height(7.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)){
                Text(
                    text = "Delivery Fee",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$deliver FCFA",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    color = Black
                )
            }
            Divider(
                modifier = Modifier.padding(16.dp),
                color = md_theme_light_onPrimary,
                thickness = 1.dp
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)){
                Text(
                    text = "Total",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$somme FCFA",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    color = Black
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))

    Button(
        onClick = { showDialog = true },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            LightGreen,
            contentColor = LightGreen
        ),
        modifier = Modifier
            .fillMaxWidth()
            .width(20.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Payer : $somme f CFA",
            fontSize = 11.sp,
            modifier = Modifier.padding( 0.dp),
            color = white,
            maxLines = 1
        )
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Confirmation") },
            text = { Text(text = "Votre commande a été prise en compte") },
            confirmButton = {
                Button(onClick = { if(showDialog) navController.navigate(Screen.HomeScreen.route)  },
                    colors = ButtonDefaults.buttonColors(LightGreen)
                    ) {
                    Text("OK")
                }
            },
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(30.dp),
        )
    }
}

@Composable
fun Payement(navController : NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                color = white,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ){
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painter = painterResource(R.drawable.payment2),
                    contentDescription = null,
                    tint = LightGreen2,
                    modifier = Modifier
                        .size(30.dp)
                )
                Spacer(modifier = Modifier.size(size = 5.dp))
                Text(
                    text = "Payement Method",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    fontSize = 13.sp,
                    color = Black
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {navController.navigate(Screen.PayementMethodsProfile.route)}) {
                    Icon(
                        Icons.Rounded.KeyboardArrowRight,
                        contentDescription = "pencil",
                        tint = LightGreen,
                        modifier = Modifier
                            .size(28.dp)
                    )
                }


            }
            Divider(
                modifier = Modifier.padding(16.dp),
                color = md_theme_light_onPrimary,
                thickness = 1.dp
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painter = painterResource(R.drawable.discount2),
                    tint = LightGreen2,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Spacer(modifier = Modifier.size(size = 5.dp))
                Text(
                    text = "Get Discount",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    fontSize = 13.sp,
                    color = Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "pencil",
                    tint = LightGreen,
                    modifier = Modifier
                        .size(28.dp)
                )
            }
        }
    }
}

@Composable
fun CheckOutList(order: List<CheckOutData>) {
    LazyColumn {
        items(order) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(item.coverImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Row(){
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = item.argent, color = LightGreen2,fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    //Spacer(modifier = Modifier.width(80.dp))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.CenterVertically)
                    ) {

                        Column( modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.Center)) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                                    .border(1.dp, LightGreen2)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        color = white
                                    )
                            ){
                                Text(text = item.chiffre, color = LightGreen2, fontSize = 14.sp,fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Icon(
                                Icons.Rounded.Edit,
                                contentDescription = "pencil",
                                tint = LightGreen,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }
            }
            Divider(
                modifier = Modifier.padding(16.dp),
                color = md_theme_light_onPrimary,
                thickness = 1.dp
            )
        }
    }
}