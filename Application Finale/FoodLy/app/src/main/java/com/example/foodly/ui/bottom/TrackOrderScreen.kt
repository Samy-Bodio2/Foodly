package com.example.foodly.ui.bottom

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodly.component.TopAppBarMap
import com.example.foodly.ui.theme.colorWhite

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TrackOrderScreen() {
    Scaffold(topBar = {
        TopAppBarMap()
    }, backgroundColor = if (isSystemInDarkTheme()) Color.Black else colorWhite,
        content = {
            Column(modifier = Modifier.fillMaxSize()) {

            }
        })


}

@Composable
@Preview
fun TrackOrderScreenPreview() {
    TrackOrderScreen()
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun TrackOrderScreenDarkPreview() {
    TrackOrderScreen()
}