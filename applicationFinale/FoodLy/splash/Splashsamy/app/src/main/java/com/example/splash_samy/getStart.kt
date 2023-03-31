package com.example.splash_samy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splash_samy.R
import com.example.splash_samy.ui.theme.roseA
import com.example.splash_samy.ui.theme.roseR

@Composable
fun getStart(){

    val CustomTheme = darkColors(
        primary = Color.Red,
        background = Color.White
    )
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.getstartmg),
            contentDescription =null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )


Column(modifier = Modifier.fillMaxSize()
    , verticalArrangement = Arrangement.Bottom){
    Button(    colors = ButtonDefaults.buttonColors(backgroundColor = roseR),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(bottom=18.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(roseR)

        ,onClick = { /*TODO*/ }
    ) {
        Text("Get Started", color = Color.White, fontSize = 24.sp)
    }
}
            // Spacer(modifier = Modifier.weight(1f))


    }
}
@Preview
@Composable
fun GetStartPreview(){
    getStart()

}