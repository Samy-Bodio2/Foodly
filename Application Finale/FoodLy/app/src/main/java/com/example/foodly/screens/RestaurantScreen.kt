package com.example.foodly.screens

import android.os.Bundle
import com.example.foodly.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.model.CategoryResto
import com.example.foodly.model.RestaurantData
import com.example.foodly.ui.theme.*
import kotlin.text.Typography

@Composable
fun HomeScreene(navController: NavController) {

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    )
    {

        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
            Header()

            Spacer(modifier = Modifier.height(32.dp))

            OrderNowBox()

            Spacer(modifier = Modifier.height(30.dp))


            Spacer(modifier = Modifier.height(20.dp))


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Restaurant",
                // style = Typography.bo,
                fontSize = 22.sp,
                color = colorBlack
            )

            Spacer(modifier = Modifier.height(20.dp))

            PopularList(
                popularList = listOf(
                    RestaurantData(
                        R.drawable.restaurant_b,
                        title = "KMC",
                        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
                        location = "deido-cameroun",
                        rate = 5.0
                    ),
                    RestaurantData(
                        R.drawable.restaurant_a,
                        title = "Creperie",
                        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
                        location = "logbessou-cameroun",
                        rate = 4.5
                    )
                ), navController = navController
            )

        }


    }
}

@Composable
fun DetailScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, top = 48.dp, end = 30.dp)
    )
    {

        val data =
            navController.previousBackStackEntry?.arguments?.getParcelable<RestaurantData>(Destinations.DetailArgs.foodData)

        if (data != null) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                DetailHeader(navController = navController)

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
                            text = data.title,
                            //style = Typography.body1,
                            fontSize = 22.sp,
                            color = colorBlack
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
                                    // style = Typography.body1,
                                    fontSize = 14.sp,
                                    color = orange2
                                )

                                Text(
                                    text = "${data.rate}",
                                    // style = Typography.body1,
                                    fontSize = 20.sp,
                                    color = colorBlack
                                )
                            }
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {


                        Spacer(modifier = Modifier.width(14.dp))

                        Text(
                            text = "01",
                            //style = Typography.body2,
                            fontSize = 18.sp,
                            color = colorBlack
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = data.description,
                    // fontStyle = Typography.amp,
                    fontSize = 16.sp,
                    color = gray,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                DetailBox(data = data)

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "",
                    //style = Typography.body1,
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
                    Text(text = "Add ",
                        //  style = Typography.body1,
                        color = Color.White)
                }

            }

        }
    }
}

@Composable
fun Header() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)
    ) {

        BoxWithRes(resId = R.drawable.menu, description = "Menu")

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = orange2
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Cameroun")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp),
                tint = orange2
            )
        }

        BoxWithRes(resId = R.drawable.search, description = "Search")
    }
}

@Composable
fun DetailHeader(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        BoxWithRes(
            resId = R.drawable.arrow_left,
            description = "Left",
            navController = navController
        )



        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    colorWhite
                ), contentAlignment = Alignment.Center
        )
        {
            Box(
                modifier = Modifier
                    .size(24.dp)
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint =  md_theme_light_onTertiaryContainer
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
                                yellow
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun OrderNowBox() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .padding(end = 13.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                yellow
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
                            color = colorBlack,
                            // fontStyle = Typography.body1.fontStyle
                        )
                    )
                    {

                    }

                    withStyle(
                        style = SpanStyle(
                            color = yellow,
                            // fontStyle = Typography.body1.fontStyle
                        )
                    )
                    {
                        append(
                            " Resto"
                        )
                    }
                })

                Box(
                    modifier = Modifier
                        .size(width = 126.dp, height = 40.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(yellow), contentAlignment = Alignment.Center
                )
                {

                    Text(
                        text = "very delicious",
                        // style = Typography.body1,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.soda),
                contentDescription = "Drink",
                modifier = Modifier.size(156.dp)
            )
        }
    }
}

@Composable
fun DetailBox(data: RestaurantData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                colorWhite
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

            }

            Divider(
                color = placeholderColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )


            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.location}",
                    // style = Typography.body2,
                    color = colorBlack
                )
            }

            Divider(
                color = placeholderColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {

            }

        }
    }
}

@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = colorWhite,
    iconColor: Color? =  md_theme_light_onTertiaryContainer,
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
fun CategoryList(categories: List<CategoryResto>) {

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
fun CategoryItem(categoryData: CategoryResto, selectedIndex: MutableState<Int>, index: Int) {
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.value = index
            }
            .background(
                if (selectedIndex.value == index) yellow else colorWhite
            ), contentAlignment = Alignment.Center
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if (selectedIndex.value == index) Color.White else colorBlack
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = categoryData.title,
                //style = Typography.body2,
                fontSize = 18.sp,
                color = if (selectedIndex.value == index) Color.White else colorBlack
            )
        }
    }
}


@Composable
fun PopularList(popularList: List<RestaurantData>, navController: NavController) {

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
fun PopularItem(popularData: RestaurantData, navController: NavController) {

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
                        navController.currentBackStackEntry?.arguments = Bundle().apply {
                            putParcelable(Destinations.DetailArgs.foodData, popularData)
                        }
                        navController.navigate(Destinations.Detail)
                    }
                    .background(
                        colorWhite
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
                            painter = painterResource(id = R.drawable.crown),
                            contentDescription = "Crown",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(11.dp))

                        Text(
                            text = "Best Selling",
                            //style = Typography.h5,
                            fontSize = 14.sp,
                            color = secondaryFontColor
                        )
                    }
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Text(
                        text = popularData.title,
                        // style = Typography.body1,
                        fontSize = 18.sp,
                        color = colorBlack
                    )
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {

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
                            .background(yellow),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = "Add",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(48.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            modifier = Modifier.size(16.dp),
                            tint = colorBlack
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "${popularData.rate}",
                            // style = Typography.body1,
                            color = colorBlack
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