package com.example.foodly.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodly.R
import com.example.foodly.model.MealKind
import com.example.foodly.model.PopularRestaurant
import com.example.foodly.ui.theme.*
import androidx.compose.runtime.Composable


val testList = listOf(
    MealKind("Burger", R.drawable.offers),
    MealKind("Pommes pilées", R.drawable.pommes),
    MealKind("Okok", R.drawable.okok),
    MealKind("Spaghetti", R.drawable.indian)
)
val testList2 = listOf(
    PopularRestaurant(
        name = "K M C",
        rate = 4.9f,
        rateCount = 124,
        foodKind = "Western Food",
        coverImage = R.drawable.restaurant_a
    ),
    PopularRestaurant(
        name = "Tchop & Yamo",
        rate = 4.8f,
        rateCount = 137,
        foodKind = "Africain Food",
        coverImage = R.drawable.restaurant_b
    ),
    PopularRestaurant(
        name = "Cafe vienna ",
        rate = 4.7f,
        rateCount = 125,
        foodKind = "French Food",
        coverImage = R.drawable.restaurant_c
    ),
)
val testList3 = listOf(
    PopularRestaurant(
        name = "Chez Martial",
        rate = 4.9f,
        rateCount = 124,
        foodKind = "Modern Food",
        coverImage = R.drawable.restaurant_x),
    PopularRestaurant(
        name = "Friends Food",
        rate = 4.8f,
        rateCount = 137,
        foodKind = "Western Food",
        coverImage = R.drawable.restaurant_y
    ),
)
val testList4 = listOf(
    PopularRestaurant(
        name = "Pizza hut",
        rate = 4.9f,
        rateCount = 124,
        foodKind = "Western Food",
        coverImage = R.drawable.item_a
    ),
    PopularRestaurant(
        name = "Terrific coffee",
        rate = 4.8f,
        rateCount = 137,
        foodKind = "Italian Food",
        coverImage = R.drawable.item_b

    ),
    PopularRestaurant(
        name = "Creperie",
        rate = 4.7f,
        rateCount = 125,
        foodKind = "French Food",
        coverImage = R.drawable.item_c
    ),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenRestaurant(navController1: Nothing?, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        //--> Top Section
        item {
            TopBar(navController,"Jason")
            SearchField()
            Spacer(modifier = Modifier.size(18.dp))
            MealKinds(testList)
            Spacer(modifier = Modifier.size(25.dp))

        }

        //--> PopularRestaurants Section
        item {
            SectionHeader(sectionName = "Popular Restaurants") {}
            Spacer(modifier = Modifier.size(8.dp))
        }
        items(testList2) { item ->
            PopularRestaurantItem(item)
        }

        //--> MostPopular Section
        item {
            SectionHeader(sectionName = "Most Popular") {}
            Spacer(modifier = Modifier.size(8.dp))
            MostPopular(list = testList3)
        }

        //--> ResentItems Section
        item {
            SectionHeader(sectionName = "Recent Items") {}
            Spacer(modifier = Modifier.size(8.dp))
        }
        items(testList4) { item ->
            RecentItem(item)
        }
    }
}

@Composable
fun TopBar(navController: NavController, userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hello $userName!",
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 20.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = null,
            tint = primaryFontColor,
            modifier = Modifier
                .clickable {
                    navController.navigate("panierscreen") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
        )
    }
}

@Composable
fun MealKinds(list: List<MealKind>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item { Spacer(modifier = Modifier.size(12.dp)) }
        items(list) { item ->
            MealKind(item)
        }
        item { Spacer(modifier = Modifier.size(12.dp)) }

    }
}

@Composable
fun MealKind(item: MealKind) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .width(110.dp)
                .aspectRatio(1f)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Text(
            text = item.name,
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 14.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun SectionHeader(sectionName: String, viewAll: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sectionName,
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 20.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Medium
            )
        )
        TextButton(onClick = viewAll) {
            Text(
                "View all",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = orange2,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
fun PopularRestaurantItem(item: PopularRestaurant) {
    val itemRate = item.rate.toString().substring(0, 3)
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 25.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            painter = painterResource(id = item.coverImage),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 4.dp),
            text = item.name,
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 16.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(id = R.drawable.ic_star),
                contentDescription = "rating",
                tint = orange2
            )
            Text(
                text = " $itemRate ",
                style = TextStyle(
                    color = orange2,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
            Text(
                text = " (${item.rateCount} ratings)  ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )

            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(3.dp)
                    .clip(CircleShape)
                    .background(orange2)
            )
            Text(
                text = "  ${item.foodKind} ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        }

    }
}

@Composable
fun MostPopular(list: List<PopularRestaurant>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item { Spacer(modifier = Modifier.size(12.dp)) }
        items(list) { item ->
            MostPopularItem(item, modifier = Modifier.fillParentMaxWidth(0.8f))
        }
        item { Spacer(modifier = Modifier.size(12.dp)) }

    }
}

@Composable
fun MostPopularItem(item: PopularRestaurant, modifier: Modifier = Modifier) {
    val itemRate = item.rate.toString().substring(0, 3)
    Column(modifier = modifier.padding(horizontal = 8.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = item.coverImage),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(top = 6.dp),
            text = item.name,
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 16.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = " Café  ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )

            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(3.dp)
                    .clip(CircleShape)
                    .background(orange2)
            )
            Text(
                text = "  ${item.foodKind} ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )

            Icon(
                painterResource(id = R.drawable.ic_star),
                contentDescription = "rating",
                tint = orange2
            )
            Text(
                text = " $itemRate ",
                style = TextStyle(
                    color = orange2,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        }

    }
}

@Composable
fun RecentItem(item: PopularRestaurant) {
    val itemRate = item.rate.toString().substring(0, 3)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
    ) {
        Image(
            modifier = Modifier
                .width(110.dp)
                .padding(end = 20.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = item.coverImage),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = item.name,
                style = TextStyle(
                    color = primaryFontColor,
                    fontSize = 16.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "${item.foodKind} ",
                style = TextStyle(
                    color = secondaryFontColor,
                    fontSize = 13.sp,
                    fontFamily = metropolisFontFamily
                )
            )
            Spacer(modifier = Modifier.size(4.dp))
            Row {
                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = "rating",
                    tint = orange2
                )
                Text(
                    text = " $itemRate ",
                    style = TextStyle(
                        color = orange2,
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily
                    )
                )
                Text(
                    text = " (${item.rateCount} ratings)  ",
                    style = TextStyle(
                        color = secondaryFontColor,
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField() {
    var value by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 17.dp),
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = gray,
            cursorColor = orange2,
            disabledLabelColor = gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            value = it
        },
        placeholder = {
            Text(
                text = "Search food",
                style = TextStyle(
                    color = placeholderColor,
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily
                )
            )
        },
        shape = RoundedCornerShape(28.dp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                /** do something*/
                /** do something*/

                /** do something*/

                /** do something*/

                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/
                /** do something*/

                /** do something*/

                /** do something*/
                keyboardController?.hide()
            }
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = primaryFontColor,
            fontSize = 15.sp,
            fontFamily = metropolisFontFamily
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search icon",
                modifier = Modifier.padding(start = 14.dp)
            )
        }
    )
}