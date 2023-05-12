package com.projects.mealobject

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import com.projects.mealobject.R
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.projects.mealobject.ui.theme.white

@Composable
fun Repas() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Box(
                modifier = Modifier
                    .height(135.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){

                Image(
                    painter = painterResource(R.drawable.mon_repas_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(40.dp))
                )
            }
            Text(
                text = "Carl's Burger (Road 4001 Blvd)",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.paddingFromBaseline(top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "Fast food, Burger, Chicken",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
            )
            Row(  modifier = Modifier.fillMaxWidth(0.80f)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .border(
                            width = 1.dp,
                            color = white,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(color = Color.Transparent)
                        .width(width = 80.dp)
                        .height(height = 30.dp)
                ) {
                    Text(
                        text = "3,4 km",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
                Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .border(
                        width = 1.dp,
                        color = white,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(color = Color.Transparent)
                    .width(width = 80.dp)
                    .height(height = 30.dp)
                ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "(100)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .border(
                            width = 1.dp,
                            color = white,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(color = Color.Transparent)
                        .width(width = 80.dp)
                        .height(height = 30.dp)
                ) {
                    Text(
                        text = "5~15 Min",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun action1(navController: NavHostController){
    Scaffold(scaffoldState = rememberScaffoldState(),
        topBar = { TopAppbar() },
        bottomBar = { BottomApp() },
        content = { Contenu() },
        drawerContent = { draw() })
}

@Composable
fun draw() {
    //drawerContent
    Column() {
        Text("First")
        Text("Second")
        Text("Third")
    }
}

@Composable
fun Contenu() {
    //elements scrollable
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Repas()
            Repas()
            Repas()
            Repas()
            Repas()
            Repas()
        }

    }
}

@Composable
fun BottomApp() {
    Row(modifier = Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth()
        .height(50.dp)
        .background(color = Color.White), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = Icons.Default.Home,contentDescription = "",tint = Color.Black)
        Icon(imageVector = Icons.Default.Search,contentDescription = "",tint = Color.Black)
        Icon(imageVector = Icons.Default.Person,contentDescription = "",tint = Color.Black)
        Icon(imageVector = Icons.Default.Settings,contentDescription = "",tint = Color.Black)
    }
}

@Composable
fun TopAppbar() {
    var expanded by remember { mutableStateOf(false) }
    var textFiledSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }
    Column(modifier = Modifier
        .padding(horizontal = 20.dp)
        .height(80.dp)
        .fillMaxWidth()
        , verticalArrangement = Arrangement.Center){
        Row() {
            Text("ASAP", fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Default.ArrowForward,contentDescription = "", tint = Color.Black)
            Text("1226 University Road", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.size(6.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(100.dp)),
                contentAlignment = Alignment.Center
            ){
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            }
            Box(modifier = Modifier
                .height(27.dp)
                .background(color = white)
                .width(60.dp)
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                , contentAlignment = Alignment.Center){
                Text("Pickup",fontSize = 12.sp)
            }
            Box(modifier = Modifier
                .height(27.dp)
                .background(color = white)
                .width(60.dp)
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                , contentAlignment = Alignment.Center){
                Row( horizontalArrangement = Arrangement.Center){
                    Text("$$",fontSize = 12.sp)
                    //Icon(imageVector = Icons.Filled.KeyboardArrowDown , contentDescription ="" )
                }
            }
            Box(modifier = Modifier
                .height(27.dp)
                .background(color = white)
                .width(60.dp)
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                , contentAlignment = Alignment.Center){
                Row(horizontalArrangement = Arrangement.Center){
                    Text("Distary",fontSize = 12.sp)
                    // Icon(imageVector = Icons.Filled.KeyboardArrowDown , contentDescription ="" )
                }
            }/*last box*/
            Box(modifier = Modifier
                .height(27.dp)
                .background(color = white)
                .width(60.dp)
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                , contentAlignment = Alignment.Center){
                Row(horizontalArrangement = Arrangement.Center){
                    Text("People",fontSize = 12.sp)
                }
            }
        }
    }
}