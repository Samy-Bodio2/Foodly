package com.example.foodly.screens

import android.os.Bundle
import androidx.annotation.DrawableRes
import com.example.foodly.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodly.model.CategoryData
import com.example.foodly.model.PopularData
import com.example.foodly.ui.theme.*

object Destination {
    const val Home = "Home"
    const val Detail = "Detail"

    object DetailArgs {
        const val foodData = "foodData"
    }
}

@Composable
fun HomeScreenes(navController: NavController) {

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    )
    {

        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
            Headers()

            Spacer(modifier = Modifier.height(32.dp))

            OrderNowBoxs()

            Spacer(modifier = Modifier.height(30.dp))

//            Text(
//                text = "Categories",
//                style = Typography.body1,
//                fontSize = 22.sp,
//                color = BlackTextColor
//            )

            Spacer(modifier = Modifier.height(20.dp))

//            CategoryList(
//                categories = listOf(
//                    CategoryData(redId = R.drawable.pizza, title = "Pizza"),
//                    CategoryData(redId = R.drawable.hamburger, title = "Burger"),
//                    CategoryData(redId = R.drawable.drinks, title = "Drinks")
//                ),


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Menu",
                style = Typography.bodySmall,
                fontSize = 22.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))


            PopularList(
                popularList = listOf(
                    PopularData(
                        com.example.foodly.R.drawable.pile,
                        title = "Pile",
                        description = "originaire de l'ouest cameroun tres bon.",
                        info = "cook resto 20014 rue de la joie",
                        rate = 5.0,
                        price = 2000.0
//
                    ),
                    PopularData(
                        com.example.foodly.R.drawable.ekwang,
                        title = "Ekwang",
                        description = "plat tirant c'est origine du nord ouest.",
                        info = "delice d'orient 2358 rue de gaulle",
                        rate = 4.5,
                        price = 2500.0
//
                    )
                ), navController = navController
            )

        }


    }
}

@Composable
fun DetailScreene(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, top = 48.dp, end = 30.dp)
    )
    {

        val data =
            navController.previousBackStackEntry?.arguments?.getParcelable<PopularData>(Destinations.DetailArgs.foodData)

        if (data != null) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                DetailHeaders(navController = navController)

                Spacer(modifier = Modifier.height(32.dp))

                Image(
                    painter = painterResource(id = data.resId),
                    contentDescription = "",
                    modifier = Modifier.size(275.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )
                {
                    Column(verticalArrangement = Arrangement.SpaceBetween) {

                        Text(
                            text = data.title, style = Typography.bodySmall,
                            fontSize = 22.sp,
                            color = Color.Black
                        )


                        Box(
                            modifier = Modifier
                                .height(40.dp),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "",
                                    style = Typography.bodySmall,
                                    fontSize = 14.sp,
                                    color = orange2
                                )

                                Text(
                                    text = "${data.rate}",
                                    style = Typography.bodySmall,
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }

//                    Row(verticalAlignment = Alignment.CenterVertically) {
//
//                       BoxWithRes(
//                           resId = R.drawable.minus,
//                           description = "Minus",
//                           iconSize = 16,
//                           boxSize = 36,
//                            iconColor = BlackTextColor
//                       )
//
//                        Spacer(modifier = Modifier.width(14.dp))
//
//                        Text(
//                            text = "01",
//                            style = Typography.body2,
//                            fontSize = 18.sp,
//                            color = BlackTextColor
//                        )
//
//                        Spacer(modifier = Modifier.width(14.dp))
//
//                        BoxWithRes(
//                           resId = R.drawable.add,
//                          description = "Add",
//                           iconSize = 16,
//                           boxSize = 36,
//                           iconColor = Color.White,
//                          bgColor = Yellow500
//                  )
//                    }
//
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = data.description,
                    style = Typography.headlineLarge,
                    fontSize = 16.sp,
                    color = placeholderColor,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                DetailBoxs(data = data)

                Spacer(modifier = Modifier.height(20.dp))
                ServingCalculator()

                Text(
                    text = "${data.price}",
                    style = Typography.bodySmall,
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
//                    items(data.ingradients.size) { index ->
//                        Box(
//                            modifier = Modifier
//                                .size(56.dp)
//                                .clip(RoundedCornerShape(10.dp))
//                                .background(
//                                    CardItemBg
//                                ), contentAlignment = Alignment.Center
//                        )
//                        {
//                            Image(
//                                painter = painterResource(id = data.ingradients[index]),
//                                contentDescription = "",
//                                modifier = Modifier.size(width = 30.dp, height = 24.dp)
//                            )
//                        }
//                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .size(width = 203.dp, height = 56.dp)
                        .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                        .background(
                            Color.Yellow
                        ), contentAlignment = Alignment.Center
                )
                {
                    Text(text = "Add ", style = Typography.bodySmall, color = Color.White)
                }

            }

        }
    }
}

@Composable
fun Headers() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ) {

        BoxWithRes(resId = com.example.foodly.R.drawable.menu, description = "Menu")

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = com.example.foodly.R.drawable.location),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = orange2
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Cameroun")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = com.example.foodly.R.drawable.arrow_down),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp),
                tint = orange2
            )
        }

        BoxWithRes(resId = com.example.foodly.R.drawable.search, description = "Search")
    }
}

@Composable
fun DetailHeaders(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        BoxWithRes(
            resId = com.example.foodly.R.drawable.arrow_left,
            description = "Left",
            navController = navController
        )



        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    Color.White
                ), contentAlignment = Alignment.Center
        )
        {
            Box(
                modifier = Modifier
                    .size(24.dp)
            )
            {
                Icon(
                    painter = painterResource(id = com.example.foodly.R.drawable.baseline_favorite_border_24),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = md_theme_light_onTertiary
                )

                Box(
                    modifier = Modifier
                        .padding(top = 2.dp, end = 2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                )
                {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(
                                Color.Yellow
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun OrderNowBoxs() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .padding(end = 13.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                md_theme_light_onPrimary
            )
            .padding(24.dp)
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(verticalArrangement = Arrangement.SpaceBetween) {

                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontStyle = Typography.bodySmall.fontStyle
                        )
                    )
                    {
//                        append(
//                            "The Fastest In\n" +
//                                    "Delivery"
//                        )
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Yellow,
                            fontStyle = Typography.bodySmall.fontStyle
                        )
                    )
                    {
                        append(
                            " Menu"
                        )
                    }
                })

                Box(
                    modifier = Modifier
                        .size(width = 126.dp, height = 40.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(Color.Yellow), contentAlignment = Alignment.Center
                )
                {

                    Text(
                        text = "very delicious",
                        style = Typography.bodySmall,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }

            Image(
                painter = painterResource(id = com.example.foodly.R.drawable.soda),
                contentDescription = "Drink",
                modifier = Modifier.size(156.dp)
            )
        }
    }
}

@Composable
fun DetailBoxs(data: PopularData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                Color.White
            )
            .padding(15.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row {
//                Image(
//                    painter = painterResource(id = R.drawable.calori),
//                    contentDescription = "Calori",
//                    modifier = Modifier.size(20.dp)
//                )
//                Spacer(modifier = Modifier.width(10.dp))
//
//                Text(
//                    text = "${data.calori} kcal",
//                    style = Typography.body2,
//                    color = BlackTextColor
//                )
            }

            Divider(
                color = secondaryFontColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )


            Row {
                Image(
                    painter = painterResource(id = com.example.foodly.R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.info}",
                    style = AppTypography.bodyLarge,
                    color = Color.Black
                )
            }

            Divider(
                color = secondaryFontColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {

//                Image(
//                    painter = painterResource(id = R.drawable.schedule),
//                    contentDescription = "Schedule",
//                    modifier = Modifier.size(20.dp)
//                )
//
//                Spacer(modifier = Modifier.width(10.dp))
//
//                Text(
//                    text = "${data.scheduleTime} Min",
//                    style = Typography.body2,
//                    color = BlackTextColor
//                )
            }

        }
    }
}

@Composable
fun BoxWithRess(
    resId: Int,
    description: String,
    bgColor: Color? = Color.White,
    iconColor: Color? = md_theme_light_onTertiaryContainer,
    boxSize: Int? = 40,
    iconSize: Int = 24,
    navController: NavController? = null
) {

    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController?.popBackStack()
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

@Composable
fun CategoryList(categories: List<CategoryData>) {

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp), horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        items(categories.size)
        { index ->
            CategoryItem(
                categoryData = categories[index],
                selectedIndex = selectedIndex,
                index = index
            )
        }
    }
}
@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color = Color.Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        // shape = androidx.compose.material.Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResource), null)
    }
}

@Composable
fun ServingCalculator() {
    var value by remember { mutableStateOf(6) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            //.clip(androidx.compose.material.Shapes.medium)
            .background(
                Color.LightGray
            )
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Serving", Modifier.weight(1f), fontWeight = FontWeight.Medium)
        CircularButton(iconResource = com.example.foodly.R.drawable.ic_minus, elevation = null, color = Color.Yellow) { value-- }
        Text(text = "$value", Modifier.padding(16.dp), fontWeight = FontWeight.Medium)
        CircularButton(iconResource = com.example.foodly.R.drawable.ic_plus, elevation = null, color = Color.Yellow) { value++ }
    }
}
@Composable
fun CategoryItem(categoryData: CategoryData, selectedIndex: MutableState<Int>, index: Int) {
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.value = index
            }
            .background(
                if (selectedIndex.value == index) Color.Yellow else Color.White
            ), contentAlignment = Alignment.Center
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if (selectedIndex.value == index) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = categoryData.title,
                style = AppTypography.bodyLarge,
                fontSize = 18.sp,
                color = if (selectedIndex.value == index) Color.White else Color.Black
            )
        }
    }
}


@Composable
fun PopularList(popularList: List<PopularData>, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (item in popularList) {
            PopularItem(popularData = item, navController = navController)
        }
    }
}

@Composable
fun PopularItem(popularData: PopularData, navController: NavController) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(176.dp)
                    .padding(end = 13.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .clickable {
                        navController.currentBackStackEntry?.arguments != Bundle().apply {
                            putParcelable(Destination.DetailArgs.foodData, popularData)
                        }
                        navController.navigate(Destination.Detail)
                    }
                    .background(
                        Color.White
                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = com.example.foodly.R.drawable.crown),
                            contentDescription = "Crown",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(11.dp))

                        Text(
                            text = "Best Selling",
                            style = AppTypography.headlineLarge,
                            fontSize = 14.sp,
                            color = placeholderColor
                        )
                    }
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Text(
                        text = popularData.title,
                        style = AppTypography.bodySmall,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "fcfa",
                            style = AppTypography.bodySmall,
                            fontSize = 14.sp,
                            color = orange2
                        )
                        Text(
                            text = "${popularData.price}",
                            style = AppTypography.bodySmall,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }


            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
            )
            {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(width = 60.dp, height = 40.dp)
                            .clip(RoundedCornerShape(bottomStart = 18.dp, topEnd = 18.dp))
                            .background(Color.Yellow),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Icon(
                            painter = painterResource(id = com.example.foodly.R.drawable.add),
                            contentDescription = "Add",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(48.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = com.example.foodly.R.drawable.star),
                            contentDescription = "Star",
                            modifier = Modifier.size(16.dp),
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "${popularData.rate}",
                            style = AppTypography.bodySmall,
                            color = Color.Black
                        )
                    }
                }
            }


            Image(
                painter = painterResource(id = popularData.resId),
                contentDescription = popularData.title,
                modifier = Modifier
                    .size(156.dp)
                    .align(
                        Alignment.CenterEnd
                    )
            )


        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}