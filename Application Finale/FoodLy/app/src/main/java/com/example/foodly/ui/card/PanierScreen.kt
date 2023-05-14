package com.example.foodly.ui.card


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodly.component.TopAppBarMyOrders
import com.example.foodly.data.MyOrdersDataDummy
import com.example.foodly.model.MyOrders
import com.example.foodly.ui.theme.colorBlack
import com.example.foodly.ui.theme.colorRedLite
import com.example.foodly.ui.theme.colorWhite
import com.example.foodly.ui.theme.orange2

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PanierScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBarMyOrders(navController)
    },
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else colorWhite,
        content = {
            PanierMainContent(navController)
        })

}

@Composable
fun PanierMainContent(navController: NavHostController) {
    Column {
        PanierList()
        OrderCalculateData(navController )
    }
}

@Composable
fun OrderCalculateData(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("momoOM") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorRedLite),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Order \uD83E\uDD11",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }

    }
}

@Composable
fun PanierList() {
    val myOrdersTitle = remember { MyOrdersDataDummy.myOrdersList }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(
            items = myOrdersTitle,
            itemContent = {
                MyOrdersListItem(myOrders = it)
            })
    }

}

@Composable
fun MyOrdersListItem(myOrders: MyOrders) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = myOrders.ordersImageId),
            contentDescription = "",
            modifier = Modifier
                .width(82.dp)
                .height(82.dp)

        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.9f)
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = myOrders.name,
                style = MaterialTheme.typography.h6,
                color = colorBlack,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${myOrders.price}",
                style = MaterialTheme.typography.h6,
                color = orange2,
                fontWeight = FontWeight.Bold
            )

        }
        val counter = remember { mutableStateOf(1) }
        Box(
            modifier = Modifier
                .width(110.dp)
                .height(40.dp)
                .clip(shape = CircleShape)
                .background(orange2)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(colorWhite)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { counter.value-- }) {
                        Icon(
                            imageVector = Icons.Default.Minimize,
                            contentDescription = "",
                            tint = orange2,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }

                Text(
                    text = "${counter.value}",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(Color.Red)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        counter.value++
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = colorWhite,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
            }
        }

    }

    HorizontalDivider()
}

@Composable
fun HorizontalDivider() {
    Divider(
        color = orange2, thickness = 1.dp,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    )

}

@Composable
@Preview
fun OrderScreenPreview() {
    PanierScreen(navController = NavHostController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun OrderScreenDarkPreview() {
    PanierScreen(navController = NavHostController(LocalContext.current))
}