package com.example.foodly.commander

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.Customers.Splash.navigation.Screen
import com.example.foodly.R
import com.example.foodly.Splash.isLoggedIn
import com.example.foodly.ui.theme.orange2
import com.example.foodly.ui.theme.white
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Interface(navController: NavHostController){
    Scaffold(
        backgroundColor = Color.Transparent,
       /* topBar = { leHaut(modifier = Modifier.background(Color.Transparent))},*/
    content = { contenue() },
    bottomBar = { leBas() })
}

@Composable
fun leBas() {
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(orange2), modifier = Modifier
        .width(500.dp)
        .height(80.dp)
        .padding(vertical = 20.dp, horizontal = 40.dp)) {
        Text("Home",color = white)
    }
}

@Composable
fun leHaut(modifier: Modifier) {

}

@Composable
fun contenue() {
    var lit1 by remember  { mutableStateOf(false) }
    var lit2 by remember  { mutableStateOf(false) }
    var lit3 by remember  { mutableStateOf(false) }
    var lit4 by remember  { mutableStateOf(false) }
//---------------------------------------
    var navi =  rememberNavController()
    var startVal = 10000
    var startAnim by remember{
        mutableStateOf(false)
    }


//--------------------------------------
    var long : Long = 4000
    var longg by remember { mutableStateOf(long) }
    var mutFloat by remember { mutableStateOf(0f) }
    if (isLoggedIn) {
        navi.navigate("homescreen")
    } else {
        LaunchedEffect(key1 = true) {
            startAnim = true
            delay(4000)
            mutFloat = mutFloat + 0.25f
            longg += longg
            lit1 = true
            //navi.popBackStack()
            //navi.navigate(Screen.PageScreen.route)
        }
        LaunchedEffect(key1 = true) {
            startAnim = true
            delay(8000)
            mutFloat = mutFloat + 0.25f
            longg += longg
            lit2 = true
            //navi.popBackStack()
            //navi.navigate(Screen.PageScreen.route)
        }
        LaunchedEffect(key1 = true) {
            startAnim = true
            delay(12000)
            mutFloat = mutFloat + 0.25f
            longg += longg
            lit3 = true
            //navi.popBackStack()
            //navi.navigate(Screen.PageScreen.route)
        }

        LaunchedEffect(key1 = true) {
            startAnim = true
            delay(16000)
            mutFloat = mutFloat + 0.25f
            longg += longg
            lit4 = true
            //navi.popBackStack()
            //navi.navigate(Screen.PageScreen.route)
        }
    }

    var ButImg1 = if(lit1) Icon(imageVector = Icons.Default.Kitchen, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp))
    else
        Canvas(modifier = Modifier
            .size(10.dp)
            .background(color = Color.Transparent)){
            drawCircle(
                color = white, radius = size.minDimension/2,center = Offset(size.width/2,size.height/2)
            )
        }


    Box(modifier = Modifier
        .fillMaxSize() ){
        Image(painter = painterResource(id = R.drawable.track_food_back), contentDescription = "",contentScale = ContentScale.FillBounds)
        Column(){

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)){
                Icon(imageVector = Icons.Default.Menu, contentDescription = "", tint = white)
                //Spacer(modifier = Modifier.size(5.dp))
                Text("Tracking", fontSize = 30.sp, fontWeight = FontWeight.SemiBold,color = white)
               // Spacer(modifier = Modifier.size(5.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxWidth()){
                    Text(text = "Order Number",color = white)
                    Text(text = "0023345",color = white)
                }
            }
            Box(modifier = Modifier){
                LinearProgressIndicator(progress = mutFloat,color = orange2, modifier = Modifier
                    .padding(top = 180.dp, start = 35.dp)
                    .rotate(90f)
                    .width(300.dp)
                    , backgroundColor = white)
                //leHaut()
                Row(modifier = Modifier.padding( start = 180.dp, top = 32.dp)) {
                    // Spacer(modifier = Modifier.size(88.5.dp))

                    Column(modifier = Modifier.height(300.dp),verticalArrangement = Arrangement.SpaceBetween){
                        Row() {
                            Icon(imageVector = Icons.Default.Verified, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp,y=-(3).dp))
                        }
                        Row() {
                            if(lit1) Icon(imageVector = Icons.Default.Kitchen, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp,y=-(11).dp))
                            else
                                Canvas(modifier = Modifier
                                    .size(10.dp)
                                    .background(color = Color.Transparent)){
                                    drawCircle(
                                        color = white, radius = size.minDimension/2,center = Offset(size.width/2,size.height/2)
                                    )
                                }
                        }
                        Row() {
                            if(lit2) Icon(imageVector = Icons.Default.DeliveryDining, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp,y=-(11).dp))
                            else
                                Canvas(modifier = Modifier
                                    .size(10.dp)
                                    .background(color = Color.Transparent)){
                                    drawCircle(
                                        color = white, radius = size.minDimension/2,center = Offset(size.width/2,size.height/2)
                                    )
                                }
                        }
                        Row() {
                            if(lit3) Icon(imageVector = Icons.Default.Handshake, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp,y=-(11).dp))
                            else
                                Canvas(modifier = Modifier
                                    .size(10.dp)
                                    .background(color = Color.Transparent)){
                                    drawCircle(
                                        color = white, radius = size.minDimension/2,center = Offset(size.width/2,size.height/2)
                                    )
                                }
                        }
                        Row() {
                            if(lit4) Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = white, modifier = Modifier.offset(x = -(7).dp,y = 5.dp))
                            else
                                Canvas(modifier = Modifier
                                    .size(10.dp)
                                    .background(color = Color.Transparent)){
                                    drawCircle(
                                        color = white, radius = size.minDimension/2,center = Offset(size.width/2,size.height/2)
                                    )
                                }
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    columnTxt(white)
                }
            }
        }
    }
}

@Composable
fun columnTxt(colorTxt : Color) {
    Column(modifier = Modifier.height(300.dp),verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Confirmed", color = colorTxt)
        Text(text = "Cocking", color = colorTxt)
        Text(text="On the way", color = colorTxt)
        Text(text = "Delivered", color = colorTxt)
        Text(text = "Rate Us", color = colorTxt)
    }
}

