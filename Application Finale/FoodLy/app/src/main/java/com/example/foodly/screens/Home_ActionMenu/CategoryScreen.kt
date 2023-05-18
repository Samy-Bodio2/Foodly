package com.example.foodly.screens.Home_ActionMenu

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.model.categories
import com.example.foodly.ui.theme.Shapes

@Composable
fun CategoryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(title = "More Category", onNavigateUp = { /* Navigation de retour */ })
        }
    ) {it
        CategoryList()
    }
}
@Composable
fun MyAppBar(title: String, onNavigateUp: () -> Unit) {
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
}

@Composable
fun CategoryList(){
    EasyGrid(nColumns = 4, items = categories){
        CategoryCard(it.image, it.name, Modifier)
    }
}

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T>, content: @Composable (T) -> Unit){
    Column(Modifier.padding(16.dp)) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    @DrawableRes iconResource: Int,
    title: String,
    modifier: Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(bottom = 16.dp)
    ) {

        Card(
            shape = Shapes.large,
            elevation = 0.dp,
            backgroundColor = Color.White,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(bottom = 4.dp)
        ) {
            Image(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }

//            MyTextContainer(text = title)
        Text(text = title,
            modifier = Modifier
                .width(100.dp)
                .padding(horizontal = 6.dp),
            fontSize = 14.sp,
            softWrap = false,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Medium)
    }
}

@Composable
fun MyTextContainer(text: String) {
    BoxWithConstraints {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .widthIn(max = maxWidth)
                .padding(horizontal = 10.dp)
        )
    }
}


@Preview(heightDp = 1400)
@Composable
fun MoreCategoryPreview(){
    val navController = rememberNavController()
    CategoryScreen(navController)
}