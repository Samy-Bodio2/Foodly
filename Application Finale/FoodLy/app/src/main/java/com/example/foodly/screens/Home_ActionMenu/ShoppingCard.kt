package com.example.foodly.screens.Home_ActionMenu

import android.annotation.SuppressLint
import android.content.ClipData
import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.model.Meal
import com.example.foodly.model.cartList
import com.example.foodly.model.mealList
import com.example.foodly.ui.theme.FoodlyTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
@Composable
fun BasketScreen() {
    Scaffold(
        topBar = {
            TopAppbar()
        }
    ) {it

        Contenu(meals = cartList)
    }
}

@Composable
fun TopAppbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row() {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "My Cart", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Box(modifier = Modifier
            .border(1.dp, color = Black, shape = RoundedCornerShape(50.dp))
            .height(20.dp)
            .width(20.dp), contentAlignment = Alignment.Center){
            Text(text = "...",Modifier.offset(y=(-7).dp))
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
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Panier vide"
        )
        Spacer(modifier = Modifier.size(16.dp))

        Text(text = "Empty Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = "You don't have any foods in cart at this time")
    }
}



@Composable
fun MenuList(meal: Meal) {
    var isContentVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { isContentVisible = !isContentVisible },
        elevation = 8.dp
        //shape = RoundedCornerShape(16.dp)
    ) {
        Column(

        ) {
            Row( modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = meal.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                )
                Spacer(Modifier.width(20.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = meal.nom, fontWeight = FontWeight.Bold, fontSize = 20.sp, maxLines = 1)
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(text = "${meal.quantite} item(s)", fontSize = 20.sp, maxLines = 1)
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(text = "${meal.prix} f CFA",color = androidx.compose.ui.graphics.Color.Green)
                }

                Spacer(modifier = Modifier.size(40.dp))

                Row(
                ) {
                    if (isContentVisible) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null ,
                            Modifier
                                .offset(y = 25.dp)
                                .clickable { }
                                // .background(Green)
                                .padding(5.dp)
                            //HorizontalAlignment= Alignment.BottomStart
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Contenu(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MenuList(meal = meal)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodlyTheme {
        BasketScreen()
    }
}