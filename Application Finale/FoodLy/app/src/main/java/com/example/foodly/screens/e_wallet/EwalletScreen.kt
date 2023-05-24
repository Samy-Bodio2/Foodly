package com.example.foodly.screens.e_wallet


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.foodly.model.PopularRestaurant
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodly.R
import com.example.foodly.component.AddPaymentCard
import com.example.foodly.component.CreditCardFilter
import com.example.foodly.component.InputItem
import com.example.foodly.component.PaymentCard
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.LightGreen2
import com.example.foodly.ui.theme.white
import java.text.SimpleDateFormat
import java.util.*

val currentTime = SimpleDateFormat("MMM d,yyyy | HH:mm a", Locale.getDefault()).format(Date())

val testList = listOf(
    PopularRestaurant(
        name = "Big Garden Salad",
        date = currentTime,
        argent = "FCFA2120",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Top Up E-Wallet",
        date = currentTime,
        argent = "FCFA4123",
        order = "Top Up",
        coverImage = R.drawable.ekwang

    ),
    PopularRestaurant(
        name = "Vegetable Salad",
        date = currentTime,
        argent = "FCFA2800",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Vegetable Salad",
        date = currentTime,
        argent = "FCFA2800",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Top Up E-Wallet",
        date = currentTime,
        argent = "FCFA4123",
        order = "Top Up",
        coverImage = R.drawable.ekwang

    ),
)

@Suppress("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EWalletScreen(navController : NavController) {
    var nameText by remember { mutableStateOf(TextFieldValue()) }
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var expiryNumber by remember { mutableStateOf(TextFieldValue()) }
    var cvcNumber by remember { mutableStateOf(TextFieldValue()) }
    var isFormVisible by remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painterResource(id = R.drawable.heavy_dollar_sign_48px),
                            contentDescription = "E-Wallet Icon",
                            modifier = Modifier.size(32.dp),
                            tint = LightGreen2
                        )
                        Text(
                            text = "E-Wallet",
                            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                            color = Black,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                backgroundColor = Color.White,
                navigationIcon = null,
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Do Something */ }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = { isFormVisible = true }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                },
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            PaymentCard(
                nameText,
                cardNumber,
                expiryNumber,
                cvcNumber
            )


            if (isFormVisible) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    item {
                        InputItem(
                            textFieldValue = nameText,
                            label = stringResource(id = R.string.card_holder_name),
                            onTextChanged = { nameText = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        )
                    }

                    item {
                        InputItem(
                            textFieldValue = cardNumber,
                            label = stringResource(id = R.string.card_holder_number),
                            keyboardType = KeyboardType.Number,
                            onTextChanged = { cardNumber = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            visualTransformation = CreditCardFilter
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InputItem(
                                textFieldValue = expiryNumber,
                                label = stringResource(id = R.string.expiry_date),
                                keyboardType = KeyboardType.Number,
                                onTextChanged = { expiryNumber = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp)
                            )
                            InputItem(
                                textFieldValue = cvcNumber,
                                label = stringResource(id = R.string.cvc),
                                keyboardType = KeyboardType.Number,
                                onTextChanged = { cvcNumber = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 8.dp)
                            )
                        }
                    }
                    item {
                        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                            Button(
                                onClick = {  },
                                colors = ButtonDefaults.buttonColors(LightGreen),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.save),
                                    color = White
                                )
                            }

                            Button(
                                onClick = { isFormVisible = false },
                                colors = ButtonDefaults.buttonColors(Color.Gray),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text(
                                    text = "Hide",
                                    color = White,
                                    modifier = Modifier.height(15.dp)
                                )
                            }
                        }
                    }
                }
            }

            /*
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        color = LightGreen2,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                AddPaymentCard()
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row{
                        Column() {
                            Text(
                                text = "Andrew Ainsley",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "**** **** **** 3629",
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier = Modifier.width(110.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.width(3000.dp).height(80.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.visa),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }

                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Your balance",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "FCFA9379",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(60.dp))
                        Button(
                            onClick = { /* TODO */ },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color.White,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .height(40.dp)
                                .padding(start = 16.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shop),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(10.dp)
                            )
                            Text(
                                text = "Top Up",
                                modifier = Modifier.padding(start = 8.dp),
                                color = Color.Black
                            )
                        }
                    }
                }
            }*/
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Transaction History",
                    color = Black,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.width(110.dp))
                TextButton(
                    onClick = {
                        navController.navigate(Screen.TransactionHistoryScreen.route)
                    }
                ) {
                    Text(
                        text = "See All",
                        color = LightGreen2
                    )
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "Localized description",
                        modifier = Modifier.padding(end = 8.dp),
                        tint = LightGreen2
                    )
                }
            }
            PopularRestaurantList(testList)
        }
    }
}


@Composable
fun PopularRestaurantList(testList: List<PopularRestaurant>) {
    LazyColumn {
        items(testList) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(item.coverImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Row(){
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = item.date, color = Color.Gray, fontSize = 12.sp)
                    }
                    //Spacer(modifier = Modifier.width(80.dp))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.CenterVertically)
                    ) {

                        Column( modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.Center)) {

                            Text(text = item.argent, color = Black, fontSize = 20.sp,fontWeight = FontWeight.Bold,modifier = Modifier.offset(x=25.dp))
                            Spacer(modifier = Modifier.height(5.dp))
                            Row() {
                                Spacer(modifier = Modifier.width(1.dp))
                                Text(
                                    text = item.order,
                                    style = MaterialTheme.typography.subtitle1,
                                    modifier = Modifier.padding(start = 28.dp)
                                )

                                Image(
                                    painter = painterResource(if (item.order == "Orders") R.drawable.upe else R.drawable.down),
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}