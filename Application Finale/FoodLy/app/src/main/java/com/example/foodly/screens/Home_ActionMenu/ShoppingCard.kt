package com.example.foodly.screens.Home_ActionMenu

import android.annotation.SuppressLint
import android.content.ClipData
import android.inputmethodservice.Keyboard
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.foodly.R
import com.example.foodly.model.Meal
import com.example.foodly.model.Meals
import com.example.foodly.model.cartList
import com.example.foodly.model.mealList
import com.example.foodly.navigation.Screen
import com.example.foodly.screens.RestaurantDetail_Order.Menu
import com.example.foodly.ui.theme.FoodlyTheme
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.colorWhite
import com.example.foodly.utils.read
import com.example.foodly.utils.readConfirmedMenus
import com.example.foodly.viewmodels.PanierViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
@Composable
fun ShoppingCard(navController: NavController) {
    val viewModel = remember { PanierViewModel() }
    Scaffold(
        topBar = {
            TopAppbar(navController)
        },
        bottomBar = {

        }
    ) {it

        //MenuList(meals = viewModel.cartList)
        MenuList(meals = cartList, navController)
    }
}

@Composable
fun TopAppbar(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row() {
          IconButton(onClick = { navController.navigate(Screen.HomeScreen.route) }) {
              Icon(Icons.Filled.ArrowBack, contentDescription = "Search")
          }
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "My Cart", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Box(modifier = Modifier
            .border(1.dp, color = Black, shape = RoundedCornerShape(50.dp))
            .height(20.dp)
            .width(20.dp), contentAlignment = Alignment.Center){
            Text(text = "...LOVE",Modifier.offset(y=(-7).dp))
        }

    }
}




@Composable
fun EmptyBasket() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.emptycard),
            contentDescription = "Panier vide"
        )
        Spacer(modifier = Modifier.size(16.dp))

        Text(text = "Empty Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = "You don't have any foods in cart at this time")
    }
}


fun calculPrice(list: MutableList<MenuItem?>): Double{
    var somme : Double = 0.0
    list.forEach{
        item ->
        somme += (item!!.price * item!!.quantiteCom)
    }
    return somme
}
@Composable
fun MenuList(meals: List<Meal>, navController: NavController) {
    if (cartList.isEmpty()) {
        EmptyBasket()
    }else{
        val list by remember { mutableStateOf(readConfirmedMenus()) }
        var totalPrice  by remember { mutableStateOf(0.0)}// Create a variable to hold the total price
        totalPrice = calculPrice(list)
        LazyColumn {
            items(list) { meal ->
                var quant by remember { mutableStateOf(1)}
                var total by remember { mutableStateOf(0)}
                total = totalPrice.toInt()
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(

                    ) {
                        Row( modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            val imagePainter: Painter = rememberImagePainter(meal!!.Image)
                            Image(
                                painter = imagePainter,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(80.dp)
                            )
                            Spacer(Modifier.width(20.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = meal!!.name, fontWeight = FontWeight.Bold, fontSize = 20.sp, maxLines = 1)
                                Spacer(modifier = Modifier.size(3.dp))
                                //Text(text = "${meal.quantite} item(s)", fontSize = 20.sp, maxLines = 1)
                                Text(text = "${quant} item(s)", fontSize = 20.sp, maxLines = 1)
                                Spacer(modifier = Modifier.size(3.dp))
                                Text(text = "${meal!!.price} f CFA",color = LightGreen)
                            }
                            Spacer(Modifier.width(20.dp))
                            Column(Modifier.height(90.dp).width(20.dp), verticalArrangement = Arrangement.SpaceBetween) {
                                Box(
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                        .background(LightGreen)
                                        .size(32.dp, 32.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    IconButton(onClick = {
                                        quant = incrementation(meal)
                                        totalPrice = calculPrice(list)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "",
                                            tint = colorWhite,
                                            modifier = Modifier.size(20.dp, 20.dp)
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                        .background(LightGreen)
                                        .size(32.dp, 32.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    IconButton(onClick = {
                                        quant = decrementation(meal)
                                        totalPrice = calculPrice(list)
                                    }) {
                                        androidx.compose.material3.Icon(
                                            imageVector = Icons.Default.Remove,
                                            contentDescription = "",
                                            tint = colorWhite,
                                            modifier = Modifier.size(20.dp, 20.dp)
                                        )
                                    }
                                }
                            }
                        }

                    }

                }

                // totalPrice += meal!!.price.toInt() // Add the price of the current menu item to the total price
            }
        }
        //
        Button(
            onClick = { navController.navigate(Screen.CheckOutOrder.route) },
            colors = ButtonDefaults.buttonColors( LightGreen ),
            modifier = Modifier.offset(y = 450.dp).fillMaxWidth().padding(horizontal = 16.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            totalPrice = calculPrice(list)
            Text(text = "Orders : $totalPrice f CFA", color = White, fontWeight = FontWeight.SemiBold)
        }

    }
}
fun incrementation(meal: MenuItem): Int
{
    meal.quantiteCom = meal.quantiteCom + 1
    Log.i("Incrementation", meal.quantiteCom.toString())
    return  meal.quantiteCom
}

fun decrementation(meal: MenuItem): Int
{
    if(meal.quantiteCom > 1) {
        meal.quantiteCom = meal.quantiteCom - 1
        Log.i("Decrementation", meal.quantiteCom.toString())
    }

    return meal.quantiteCom
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodlyTheme {
        val navController = rememberNavController()
        ShoppingCard(navController)
    }
}