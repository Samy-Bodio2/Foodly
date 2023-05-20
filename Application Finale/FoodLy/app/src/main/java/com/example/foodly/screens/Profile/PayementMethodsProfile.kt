//package com.example.foodly.screens.Profile
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.example.foodly.R
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
//    RoundedButton1(
//        label = "Add New Card",
//        backgroundColor = Color.LightGray
//    )
//    Spacer(modifier = Modifier.height(16.dp) )
//    RoundedButton1(
//        label = "Apply",
//        backgroundColor = Color.Green
//    )
//}
//
//
//
//@Composable
//fun RoundedButton1(label: String, backgroundColor: Color) {
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



import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PayementMethodsProfile(){
    var isChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar( backgroundColor = white,
                navigationIcon = {
                    IconButton(onClick = {
//                        navController.navigate("EWalletScreen") {
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.Black,
                            contentDescription = "Retour"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Deliver To",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .background(color = md_theme_light_onPrimary)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 0}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.wallet),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )

                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Wallet",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.size(size = 12.dp))
                                Button(
                                    onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                    modifier = Modifier
                                        .width(67.dp)
                                        .height(35.dp)
                                ) {
//                                    Text(
//                                        text = "Default",
//                                        color = LightGreen2,
//                                        fontSize = 10.sp
//                                    )
                                }
                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            Text(
//                                text = "Times Square, Douala, 27, Cameroun, Afrique",
//                                fontSize = 12.sp
//                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 0,
                            onClick = { selectedOption = 0 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = white
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 1}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.paypal),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Paypal",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            Text(
//                                text = "5259,Douala,Rue desespoir, Cameroun, Afrique",
//                                fontSize = 12.sp
//                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 1,
                            onClick = { selectedOption = 1 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = white
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 2}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Mobile Money",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            Text(
//                                text = "Bonamoussadi, Douala, 27, Cameroun, Afrique",
//                                fontSize = 12.sp
//                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 2,
                            onClick = { selectedOption = 2 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = white
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 3}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.apple),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "Orange Money",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            Text(
//                                text = "Hilton Hotel, Douala, 27, Cameroun, Afrique",
//                                fontSize = 12.sp
//                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 3,
                            onClick = { selectedOption = 3 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = white
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = white,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clickable { selectedOption = 4}
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.master),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.size(size = 5.dp))
                        Column {
                            Row() {
                                Text(
                                    text = "MasterCard",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            Text(
//                                text = "Times Square, Douala, 27, Cameroun, Afrique",
//                                fontSize = 12.sp
//                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedOption == 4,
                            onClick = { selectedOption = 4 },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = LightGreen,
                                unselectedColor = white
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(7.dp))
                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        LightGreen3,
                        contentColor = LightGreen3
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(20.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "Add New Card",
                        fontSize = 11.sp,
                        modifier = Modifier.padding( 0.dp),
                        color = LightGreen,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.height(13.dp))
                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        LightGreen2,
                        contentColor = LightGreen2
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(20.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "Apply",
                        fontSize = 11.sp,
                        modifier = Modifier.padding( 0.dp),
                        color = white,
                        maxLines = 1
                    )
                }
            }
        }
    }
}