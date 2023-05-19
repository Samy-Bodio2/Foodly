package com.example.foodly.screens.Orders

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen

import com.example.foodly.ui.theme.md_theme_light_inverseSurface



@Composable
fun CategoryItem() {
    Scaffold(
        topBar = {
            AppBarCat()
        }

    ) {it
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Top

        ){
            MealListe(mealLists)
            Spacer(modifier = Modifier.width(width = 30.dp))
            MealListe2(mealListsT3)
            Spacer(modifier = Modifier.width(width = 30.dp))
            MealListe3(mealLists3)
        }
    }
}

@Composable
fun AppBarCat() {
    Column(modifier = Modifier.height(100.dp),
           horizontalAlignment = Alignment.Start
          ){
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

             ){
            Spacer(modifier = Modifier.padding(top=20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.salad), contentDescription = "Homme Screen",
                        modifier = Modifier
                            .height(45.dp)
                            .padding(top = 8.dp)
                    )
            Spacer(modifier = Modifier.width(width = 6.dp))

            Text(text = "Orders", fontSize = 19.sp, modifier = Modifier .padding(top = 10.dp),)

            Spacer(modifier = Modifier.width(width = 230.dp))
            Image(
                painter = painterResource(id = R.drawable.search), contentDescription = "Homme Screen",
                modifier = Modifier
                    .height(30.dp)
                    .padding(top = 10.dp)
            )
                }
        titleNavigation()
        }
    }
@Composable
fun titleNavigation(){
    Row(
        modifier = Modifier
            .padding(horizontal = (17.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            "Filter", fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),

        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Filter", fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),

            )

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Filter", fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(start = 30.dp),


            )

        Spacer(modifier = Modifier.width(8.dp))


    }

}

@Composable
fun TopBar(){
    Column(modifier = Modifier.height(100.dp)){
        Row(modifier = Modifier.padding(15.dp)) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(text = "Hamburger",
                fontSize = 25.sp
            )
        }


    }
}

@Composable
fun SortButton(){
    Row(
        modifier = Modifier
            .padding(horizontal = (17.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Green),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_24 ),
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.height(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Filter", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Green),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_24 ),
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.height(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Filter", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Green),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_24 ),
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.height(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Filter", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(horizontal = 0.dp),
            onClick = { /* Gérer l'événement du clic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Green),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_filter_24 ),
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.height(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Filter", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

    }


}

@Composable
fun MealListe(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MealCart(meal = meal)
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}
@Composable
fun MealListe2(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MealCart2(meal = meal)
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun MealListe3(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MealCart3(meal = meal)
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun MealCart(meal: Meal) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = meal.image),
                contentDescription = meal.nom,
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .padding(5.dp)
                    .background(color = md_theme_light_inverseSurface)
            )
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(text = meal.nom, style = MaterialTheme.typography.h5,fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.width(24.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${meal.note}")
                }


                Spacer(modifier = Modifier.width(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {
                    Text(text = "${meal.prix}f CFA", modifier = Modifier.weight(1f))

                    Button(
                        modifier = Modifier
                            .fillMaxHeight()
                            .height(35.dp)
                            .padding(end = 50.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, LightGreen),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text("Filter", fontWeight = FontWeight.Bold,
                                fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MealCart2(meal: Meal) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = meal.image),
                contentDescription = meal.nom,
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .padding(5.dp)
                    .background(color = md_theme_light_inverseSurface)
            )
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(text = meal.nom, style = MaterialTheme.typography.h5,fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.width(24.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${meal.note}")
                }


                Spacer(modifier = Modifier.width(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {
                    Text(text = "${meal.prix}f CFA", modifier = Modifier.weight(1f))

                    Button(
                        modifier = Modifier
                            .fillMaxHeight()
                            .height(35.dp)
                            .padding(end = 50.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, LightGreen),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text("Filter", fontWeight = FontWeight.Bold,
                                fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MealCart3(meal: Meal) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = meal.image),
                contentDescription = meal.nom,
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .padding(5.dp)
                    .background(color = md_theme_light_inverseSurface)
            )
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(text = meal.nom, style = MaterialTheme.typography.h5,fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.width(24.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${meal.note}")
                }


                Spacer(modifier = Modifier.width(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {
                    Text(text = "${meal.prix}f CFA", modifier = Modifier.weight(1f))

                    Button(
                        modifier = Modifier
                            .fillMaxHeight()
                            .height(35.dp)
                            .padding(end = 50.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, LightGreen),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text("Filter", fontWeight = FontWeight.Bold,
                                fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun  OrderScreens(){
    CategoryItem()
}
