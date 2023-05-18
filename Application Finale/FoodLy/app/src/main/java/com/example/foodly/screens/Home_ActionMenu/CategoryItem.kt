package com.example.foodly.screens.Home_ActionMenu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.model.Meal
import com.example.foodly.model.mealList


@Composable
fun CategoryItem(navController: NavController) {
    Scaffold(
        topBar = {
            AppBarCat("Hamburger", onNavigateUp = { /* Navigation de retour */ })
        }
    ) {it

        MealListe(mealList)
    }
}

@Composable
fun AppBarCat(title: String, onNavigateUp: () -> Unit) {
    Column(modifier = Modifier.height(100.dp)){
        TopAppBar(
            title = {
                Text(text = title)
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            navigationIcon = {
                IconButton(onClick = onNavigateUp) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Bouton retour")
                }
            },
            elevation = 0.dp
        )
        SortButton()
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

        SortButton()
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
            )
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(text = meal.nom, style = MaterialTheme.typography.h5,fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.width(24.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "${meal.note}")
                }


                Spacer(modifier = Modifier.width(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "${meal.prix}f CFA", modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24 ),
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun previewCategoryItem(){
    val navController = rememberNavController()
    CategoryItem(navController)
}

