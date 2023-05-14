package com.example.foodly.ui.bottom

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.component.TopAppBarHome
import com.example.foodly.ui.theme.*
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    FoodlyTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerContent = {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            id = "home",
                            title = "Home",
                            contentDescription = "Go to home screen",
                            icon = Icons.Default.Home
                        ),
                        MenuItem(
                            id = "settings",
                            title = "Settings",
                            contentDescription = "Go to settings screen",
                            icon = Icons.Default.Settings
                        ),
                        MenuItem(
                            id = "help",
                            title = "Help",
                            contentDescription = "Get help",
                            icon = Icons.Default.Info
                        ),
                    ),
                    onItemClick = {
                        println("Clicked on ${it.title}")
                    }
                )
            }
        ) {

        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else colorWhite)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            TopAppBarHome()
            Spacer(modifier = Modifier.height(30.dp))
            //Title()
            Spacer(modifier = Modifier.height(20.dp))
            Content(navController)
        }

    }
}

@Composable
fun Title() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What would you like to\n" +
                    "eat today \uD83D\uDE0B",
            color = colorBlack,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun Content(navController: NavController) {
    Column() {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection(navController)
        Spacer(modifier = Modifier.height(20.dp))
        PopularSection()
        Spacer(modifier = Modifier.height(20.dp))
        OfferDealSection()


    }
}


@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var usersearch by remember { mutableStateOf("") }

        Card(
            modifier = Modifier.height(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorWhite,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = usersearch,
                shape = RoundedCornerShape(24.dp),
                singleLine = true,
                onValueChange = { usersearch = it },
                placeholder = {
                    Text(
                        text = "Search food",
                        color = Color.Gray
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = CircleShape)
                            .background(orange2)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.FilterList,
                                contentDescription = "",
                                tint = colorWhite
                            )
                        }
                    }
                },
            )
        }
    }

}

@Composable
fun CategorySection(navController: NavController) {
    Column() {
        val itemList = listOf("Burgers", "Pizza", "Healthy")
        val categoryImagesList = listOf<Int>(
            R.drawable.burger2,
            R.drawable.pizza,
            R.drawable.salad,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories",
                color = colorBlack,
                style = MaterialTheme.typography.h6
            )
            TextButton(
                onClick = {
                }
            ) {
                Text(
                    text = "See all",
                    color = orange2,
                    modifier = Modifier.clickable{
                        navController.navigate("homeScreenes") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Localized description",
                    modifier = Modifier.padding(end = 8.dp),
                    tint = orange2
                )
            }


        }


        LazyRow(modifier = Modifier.fillMaxWidth(), content = {
            items(itemList.size) { item ->

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(color = if (item == 0) orange2 else orange2),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(categoryImagesList[item]),
                            contentDescription = "",
                            modifier = Modifier
                                .size(60.dp, 60.dp)
                                .padding(start = 20.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            modifier = Modifier
                                .padding(
                                    start = 5.dp,
                                    end = 16.dp,
                                    top = 8.dp,
                                    bottom = 8.dp
                                ),
                            text = itemList[item],
                            color = if (item == 0) colorWhite else Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

            }
        })
    }
}

@Composable
fun PopularSection() {
    Column() {

        val popularImagesList = listOf<Int>(
            R.drawable.burger,
            R.drawable.burger2,
        )
        val popularTitleNameList = listOf("Chicken Burger", "Beef Burger")
        val popularSubTitleItemList = listOf("Burger King", "Shake Shack")
        val popularPriceItemList = listOf("4.25", "3.45")
        val popularPriceTagItemList = listOf("$ ", "$ ")

        Text(
            text = "Popular now \uD83D\uDD25",
            style = MaterialTheme.typography.h6,
            color = colorBlack
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), content = {
                items(popularImagesList.size) { item ->
                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentHeight()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(24.dp))
                            .border(width = 1.dp, color = orange2)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(popularImagesList[item]),
                                contentDescription = "",
                                contentScale = ContentScale.Fit
                            )

                            Text(
                                text = popularTitleNameList[item],
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h6,
                                color = colorBlack
                            )

                            Text(
                                text = popularSubTitleItemList[item],
                                fontWeight = FontWeight.Normal,
                                style = MaterialTheme.typography.button,
                                color = Color.Gray
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                orange2,
                                                fontWeight = FontWeight.Bold
                                            )
                                        ) {
                                            append(popularPriceTagItemList[item])
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                orange2
                                            )
                                        ) {
                                            append(popularPriceItemList[item])
                                        }
                                    },
                                    style = MaterialTheme.typography.h6,


                                    )


                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(orange2)
                                        .padding(4.dp)
                                        .clickable { },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.size(20.dp, 20.dp),
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Add",
                                        tint = colorWhite
                                    )
                                }

                            }
                        }
                    }
                }
            }
        )

    }
}

@Composable
fun OfferDealSection() {
    Column() {
        val offerDealImagesList = listOf<Int>(
            R.drawable.burger,
            R.drawable.burger2,
        )
        val offerDealTitleNameList = listOf("Chicken Burger", "Beef Burger")
        val offerDealSubTitleItemList = listOf("Burger King", "Shake Shack")
        val offerDealPriceItemList = listOf("1.25", "1.45")
        val offerDealPriceTagItemList = listOf("$ ", "$ ")

        Text(
            text = "Offer & Deal \uD83D\uDE04",
            style = MaterialTheme.typography.h6,
            color = colorBlack
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), content = {
                items(offerDealImagesList.size) { item ->
                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentHeight()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(24.dp))
                            .border(width = 1.dp, color = colorRedLite)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(offerDealImagesList[item]),
                                contentDescription = "",
                                contentScale = ContentScale.Fit
                            )

                            Text(
                                text = offerDealTitleNameList[item],
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h6,
                                color = colorBlack
                            )

                            Text(
                                text = offerDealSubTitleItemList[item],
                                fontWeight = FontWeight.Normal,
                                style = MaterialTheme.typography.button,
                                color = Color.Gray
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                orange2,
                                                fontWeight = FontWeight.Bold
                                            )
                                        ) {
                                            append(offerDealPriceTagItemList[item])
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                orange2
                                            )
                                        ) {
                                            append(offerDealPriceItemList[item])
                                        }
                                    },
                                    style = MaterialTheme.typography.h6,
                                )

                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .padding(4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.size(20.dp, 20.dp),
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Add",
                                        tint = colorWhite
                                    )
                                }

                            }
                        }
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(50.dp))

    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenDarkPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}



