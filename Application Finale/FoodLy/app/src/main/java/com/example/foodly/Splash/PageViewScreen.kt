package com.example.foodly.Splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.example.foodly.R
import com.example.foodly.model.PageItem
import com.example.foodly.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)

@Composable
fun PageViewScreen( navController: NavHostController){
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val list = arrayOf(PageItem(image = R.drawable.ic_page_1, title = "Find Food You Love", subTitle = "Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep"), PageItem(image = R.drawable.ic_page_2, title = "Fast Delivery", subTitle = "Fast food delivery to your home, office wherever you are"), PageItem(image = R.drawable.ic_page_3, title = "Live Tracking", subTitle = "Real time tracking of your food on the app once you placed the order"))
    FoodlyTheme {
        HorizontalPager(
            count = list.size,
            state = pagerState
        ) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = list[index].image), contentDescription = null)
                Spacer(modifier = Modifier.height(30.dp))
                Indicator(count = list.size, index = index)
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = list[index].title,
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = metropolisFontFamily,
                        color = primaryFontColor
                    )
                )
                Spacer(modifier = Modifier.height(33.dp))
                Text(
                    text = list[index].subTitle,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = metropolisFontFamily,
                        color = secondaryFontColor,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 45.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                FilledButton(modifier = Modifier.padding(horizontal = 34.dp), text = "Next") {
                    scope.launch {
                        if (index < list.size - 1) {
                            pagerState.animateScrollToPage(index + 1)
                        } else {
                            navController.navigate("login_page")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                BorderButton(modifier = Modifier.padding(horizontal = 34.dp), text = "Skip", color = secondaryFontColor) {
                //    navigateToHomeScreen()
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
@Composable
fun Indicator(count: Int, index: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until count) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(if (i == index) orange else Color.LightGray)
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}


@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 16,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        shape = RoundedCornerShape(28.dp),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontSize = fontSize.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun BorderButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = orange,
    fontSize: Int = 16,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(width = 1.dp, color = color),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = color,
                fontSize = fontSize.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}
@Preview
@Composable
fun affichePreview(){
    val navController = NavHostController(LocalContext.current)
    PageViewScreen(
        navController = navController
    )
}

