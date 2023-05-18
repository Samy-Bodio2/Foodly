<<<<<<< HEAD:Application Finale/FoodLy/app/src/main/java/com/example/foodly/screens/Profile/PayementMethods.kt
//package com.example.foodly.screens.Profile
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//
//@Composable
//fun Payement(){
//    Box(Modifier.verticalScroll(rememberScrollState())){
//        Column {
//            Header()
//            Spacer(modifier = Modifier.height(16.dp))
//            Content()
//        }
//    }
//}
//
//@Composable
//fun Header(){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(end = 13.dp)
//    ){
//        BoxWithRes(
//            resId = R.drawable.arrow_left,
//            description = "Left"
//        )
//        Row(verticalAlignment = Alignment.CenterVertically){
//            Text(text = "Payment Methods", Modifier.weight(1f), fontWeight = FontWeight.Medium)
//            Spacer(modifier = Modifier.width(36.dp))
//            Icon(
//                painter = painterResource(id = R.drawable.ic_scan),
//                contentDescription = "Down",
//                modifier = Modifier.size(16.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun Content() {
//    Column {
//        Wallet()
//        Spacer(modifier = Modifier.height(6.dp))
//        Paypal()
//        Spacer(modifier = Modifier.height(6.dp))
//        Google()
//        Spacer(modifier = Modifier.height(6.dp))
//        Apple()
//        Spacer(modifier = Modifier.height(6.dp))
//        Cash()
//        Spacer(modifier = Modifier.height(6.dp))
//        Master()
//    }
//}
//@Composable
//fun Wallet(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            //.padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.wallet),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "My Wallet",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//
//    }
//}
//@Composable
//fun Paypal(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            // .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.paypal),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "Paypal",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//
//    }
//}
//
//@Composable
//fun Google(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            // .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.google),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "Google Play",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            //   Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//
//    }
//}
//
//
//@Composable
//fun Apple(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            // .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.apple),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "Apple Pay",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            //Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//
//    }
//}
//
//@Composable
//fun Cash(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            // .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.cash),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "Cash Money",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//
//    }
//}
//
//@Composable
//fun Master(){
//    Row (verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.White)
//            // .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()) {
//        Box (contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .padding(10.dp) ) {
//            Image(
//                painter = painterResource(id = R.drawable.master),
//                contentDescription = "",
//                modifier = Modifier.size(96.dp)
//            )
//        }
//        //Spacer(modifier = Modifier.width(0.2.dp))
//        Row () {
//            Text(text = "-----4679",
//                fontWeight = FontWeight.Bold)
//        }
//        Spacer(modifier = Modifier.width(36.dp))
//        Row () {
//            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
//            // Spacer(modifier = Modifier.width(16.dp))
//            RadioButtonUI()
//        }
//
//    }
//    Spacer(modifier = Modifier.height(16.dp) )
//    RoundedButton(
//        label = "Add New Card",
//        backgroundColor = Color.LightGray
//    )
//    Spacer(modifier = Modifier.height(16.dp) )
//    RoundedButton(
//        label = "Apply",
//        backgroundColor = Color.Green
//    )
//}
//
//
//
//@Composable
//fun RoundedButton(label: String, backgroundColor: Color) {
//    Button(
//        onClick = { /* Handle email sign in button click */ },
//        shape = RoundedCornerShape(50),
//        modifier = Modifier.fillMaxWidth(),
//        colors = ButtonDefaults.buttonColors(backgroundColor)
//    ) {
//        Text(text = label, color = Color.White)
//    }
//}
//
//
//
//
//@Composable
//fun RadioButtonUI() {
//    val radioButtons = listOf(0)
//    val selectedButton = remember{ mutableStateOf(radioButtons.first()) }
//
//    radioButtons.forEach{
//        val isSelected = it == selectedButton.value
//        val colors = RadioButtonDefaults.colors(
//            selectedColor = colorResource(id = R.color.teal_200),
//            unselectedColor = colorResource(id = R.color.purple_500),
//            disabledColor = Color.Green
//        )
//        RadioButton(colors = colors, selected =isSelected , onClick = { selectedButton.value = it })
//    }
//}
//
//
//@Composable
//fun BoxWithRes(
//    resId: Int,
//    description: String,
//    bgColor: Color? = Color.White,
//    iconColor: Color? = Color.Black,
//    boxSize: Int? = 40,
//    iconSize: Int = 24
//
//) {
//
//    Box(
//        modifier = Modifier
//            .size(boxSize!!.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(bgColor!!), contentAlignment = Alignment.Center
//    )
//    {
//        Icon(
//            painter = painterResource(id = resId),
//            contentDescription = description,
//            modifier = Modifier.size(iconSize.dp),
//            tint = iconColor!!
//        )
//    }
//
//}
//
//
//
=======
package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodly.R


@Composable
fun Payement(){
    Box(Modifier.verticalScroll(rememberScrollState())){
        Column {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            Content()
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
            resId = R.drawable.arrow_left,
            description = "Left"
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Payment Methods", Modifier.weight(1f), fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.width(36.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun Content() {
    Column {
        Wallet()
        Spacer(modifier = Modifier.height(6.dp))
        Paypal()
        Spacer(modifier = Modifier.height(6.dp))
        Google()
        Spacer(modifier = Modifier.height(6.dp))
        Apple()
        Spacer(modifier = Modifier.height(6.dp))
        Cash()
        Spacer(modifier = Modifier.height(6.dp))
        Master()
    }
}
@Composable
fun Wallet(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            //.padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "My Wallet",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }


    }
}
@Composable
fun Paypal(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            // .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.paypal),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "Paypal",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }


    }
}

@Composable
fun Google(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            // .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "Google Play",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            //   Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }


    }
}


@Composable
fun Apple(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            // .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "Apple Pay",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            //Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }


    }
}

@Composable
fun Cash(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            // .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.cash),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "Cash Money",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }


    }
}

@Composable
fun Master(){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            // .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()) {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(10.dp) ) {
            Image(
                painter = painterResource(id = R.drawable.master),
                contentDescription = "",
                modifier = Modifier.size(96.dp)
            )
        }
        //Spacer(modifier = Modifier.width(0.2.dp))
        Row () {
            Text(text = "-----4679",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(36.dp))
        Row () {
            // Text(text = "4500 fcfa",fontWeight = FontWeight.Bold )
            // Spacer(modifier = Modifier.width(16.dp))
            RadioButtonUI()
        }

    }
    Spacer(modifier = Modifier.height(16.dp) )
    RoundedButton(
        label = "Add New Card",
        backgroundColor = Color.LightGray
    )
    Spacer(modifier = Modifier.height(16.dp) )
    RoundedButton(
        label = "Apply",
        backgroundColor = Color.Green
    )
}



@Composable
fun RoundedButton(label: String, backgroundColor: Color) {
    Button(
        onClick = { /* Handle email sign in button click */ },
        shape = RoundedCornerShape(50),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(text = label, color = Color.White)
    }
}




@Composable
fun RadioButtonUI() {
    val radioButtons = listOf(0)
    val selectedButton = remember{ mutableStateOf(radioButtons.first()) }

    radioButtons.forEach{
        val isSelected = it == selectedButton.value
        val colors = RadioButtonDefaults.colors(
            selectedColor = colorResource(id = R.color.teal_200),
            unselectedColor = colorResource(id = R.color.purple_500),
            disabledColor = Color.Green
        )
        RadioButton(colors = colors, selected =isSelected , onClick = { selectedButton.value = it })
    }
}


@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = Color.White,
    iconColor: Color? = Color.Black,
    boxSize: Int? = 40,
    iconSize: Int = 24

) {

    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
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



>>>>>>> 8be749a931a23e75bbbafd8cb3934f407829249c:Application Finale/FoodLy/app/src/main/java/com/example/foodly/screens/Profile/PayementMethodsProfile.kt
