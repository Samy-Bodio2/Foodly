package com.example.foodly.Splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodly.R
import com.example.foodly.Splash.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(targetValue =
    if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ))

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splashmg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = alpha)
        )
        Text(
            text = "Foodly",
            fontSize = 50.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
    }
}

@Composable
fun SplashScreenPreview(){
    Splash(alpha = 1f)
}