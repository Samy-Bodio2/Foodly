package com.example.foodly.screens.Orders

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen


@Composable
fun OrderScreen(navController: NavController) {
    androidx.compose.material3.Scaffold(
        topBar = {
            TopAppBar(
                title = { androidx.compose.material3.Text("Orders") },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.salad),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                    )
                }
            )
        }){}
    Row(modifier =  Modifier .padding(top = 8.dp), horizontalArrangement = Arrangement.Center){
        Spacer(modifier = Modifier.padding(top= 20.dp))
        Column {
            Spacer(modifier = Modifier.padding(top= 20.dp))
            AppBarCat()
            Spacer(modifier = Modifier.padding(top= 20.dp))
            Content()
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

        }
        Spacer(modifier = Modifier.padding(top=30.dp))
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

//menu
@Composable
fun Content(){
    Column {
        Menu()
        Spacer(modifier = Modifier.height(20.dp))
        SortButton()
        Spacer(modifier = Modifier.height(20.dp))
        Menu2()
        Spacer(modifier = Modifier.height(20.dp))
        SortButton()
        Spacer(modifier = Modifier.height(20.dp))
        Menu3()
    }
}


@Composable
fun Menu(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem(
                imagePainter = painterResource(id = R.drawable.okok),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun Menu2(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem2(
                imagePainter = painterResource(id = R.drawable.okok),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun Menu3(){
    LazyRow(
        Modifier.height(90.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            MenuItem3(
                imagePainter = painterResource(id = R.drawable.okok),
                title= "Zero Zero Noodles",
                descrip = "4 items | 27 km",
                price = 10.50f,
                backgroundColor= Color.White
            )
        }
    }
}
@Composable
fun MenuItem(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(
        Modifier
            .width(320.dp)
            .height(630.dp) ,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,

        ) {
        Row {
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .height(150.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}", fontWeight = FontWeight.Bold,modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}", modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", color =LightGreen,fontWeight = FontWeight.Bold,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", modifier = Modifier .padding(0.dp))

                    }


                }
            }
        }
    }
}

@Composable
fun MenuItem2(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(
        Modifier
            .width(320.dp)
            .height(630.dp) ,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,

        ) {
        Row {
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .height(150.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}", fontWeight = FontWeight.Bold, modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}",modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", color = LightGreen ,fontWeight = FontWeight.Bold ,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", fontWeight = FontWeight.Bold, modifier = Modifier .padding(0.dp))

                    }


                }
            }
        }
    }
}

@Composable
fun MenuItem3(
    imagePainter: Painter,
    title: String ="",
    descrip: String ="",
    price: Float,
    backgroundColor: Color = Color.Transparent) {
    Card(
        Modifier
            .width(320.dp)
            .height(630.dp) ,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,

        ) {
        Row {
            Box(
                modifier = Modifier.run {
                    width(100.dp)
                        .height(150.dp)

                }
            ) {
                Image(
                    painter = imagePainter, contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "${title}" ,fontWeight = FontWeight.Bold , modifier = Modifier .padding(horizontal = 2.dp, vertical = 2.dp))
                Spacer(modifier = Modifier.padding(top =5.dp))
                Text(text = "${descrip}", modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 2.dp) )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${price}f CFA", fontWeight = FontWeight.Bold,color = LightGreen,modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp, vertical = 2.dp))
                    Button(
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                            .padding(bottom = 7.dp),
                        onClick = { /* Gérer l'événement du clic */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightGreen,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(2.dp, color = LightGreen),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Text("Completed", fontWeight = FontWeight.Bold, modifier = Modifier .padding(0.dp))

                    }


                }
            }
        }
    }
}

//btn

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
                contentColor = LightGreen
            ),
            border = BorderStroke(2.dp, LightGreen),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = Modifier.width(4.dp))
                Text("Leave a Review", fontWeight = FontWeight.Bold,
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
                backgroundColor = LightGreen,
                contentColor = Color.White
            ),
            border = BorderStroke(2.dp, LightGreen),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(4.dp))
                Text("Order Again", fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))





    }


}

@Preview
@Composable
fun  OrderScreens(){
    val navController = rememberNavController()
    OrderScreen(navController)
}
