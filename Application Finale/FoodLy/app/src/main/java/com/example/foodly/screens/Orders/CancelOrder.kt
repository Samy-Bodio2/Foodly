package com.example.foodly.screens.Orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CancelOrder(navController: NavController) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            //  .padding(start = 30.dp, top = 48.dp, end = 17.dp)
            .padding(end = 13.dp)
    )
    {
        Column(modifier = Modifier.verticalScroll(state = scrollState)){
            Header()
            Spacer(modifier = Modifier.height(32.dp))
            Level()
            Spacer(modifier = Modifier.height(32.dp))
            RadioSelection()
            Spacer(modifier = Modifier.height(32.dp))
            Buttun()
        }
    }
}

@Composable
fun Header(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ){
        BoxWithRes(
            resId = com.example.foodly.R.drawable.arrow_left,
            description = "Left"
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Cancel Order", Modifier.weight(1f), fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun Level(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            //.clip(androidx.compose.material.Shapes.medium)
            .background(
                Color.White
            )
            .padding(horizontal = 16.dp)){
        Text(text = "Please select the reason for cancellation", Modifier.weight(1f), fontWeight = FontWeight.Medium)
    }
}

@Composable
fun RadioSelection(){
    var radiostat by remember {
        mutableStateOf(0)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically){
        Column(verticalArrangement = Arrangement.SpaceAround){
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize=10.sp
                    )
                )
                {
                    val radiooption = listOf(
                        "Waiting for long time",
                        "Unable to contact driver",
                        "Driver denied to go destination",
                        "Driver denied to come to pickup",
                        "Wrong address shown",
                        "The price is not reasonable",
                        "I want to order another restaurant",
                        "I just want to cancel")

                    radiooption.forEachIndexed { i, option: String ->
                        Row( horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(selected = radiostat == i,
                                onClick = {
                                    radiostat = i
                                })
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(option)
                        }
                    }
                }
            })
        }
    }



}
@Composable
fun Buttun(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.Center)
                .padding(vertical = 6.dp)
                .heightIn(min = 48.dp, max = 72.dp)
                .padding(horizontal = 16.dp)
                .background(Color.Blue)
                .clip(RoundedCornerShape(24.dp))
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(24.dp))
        ){
            Text(
                text = "Submit",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 18.sp
            )
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
    iconSize: Int = 24){

    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                //navController?.popBackStack()
            }
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

