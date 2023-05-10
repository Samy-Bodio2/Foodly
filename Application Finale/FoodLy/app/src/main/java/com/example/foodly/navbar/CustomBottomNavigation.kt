package com.example.foodly.navbar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.Customers.Splash.navigation.Screen


@Composable
fun CustomBottomNavigation(navController: NavController,
    selectedRoute:String,
    onItemSelected:(Screen)->Unit
) {


    val items= listOf(
        Screen.Homes,
        Screen.Favorites,
        Screen.Search,
        Screen.Profile,
        Screen.Settings

    )

    val navShape= RoundedCornerShape(topStart = 24.dp,topEnd = 24.dp)

    Row(
        modifier = Modifier
            .shadow(elevation = 40.dp, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .clip(navShape)
            .background(MaterialTheme.colors.surface)
            .padding(vertical = 22.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {


        items.forEach {

            val isSelected=it.route==selectedRoute

            val color=if (isSelected)
                MaterialTheme.colors.primary
            else
                MaterialTheme.colors.onSurface.copy(alpha=0.7f)

            IconButton(onClick = {
                if(!isSelected)
                    onItemSelected(it)
            }) {
                it.icon?.let { it1 ->
                    Icon(
                        imageVector = it1,
                        contentDescription = null,
                        tint=color
                    )
                }
            }

        }


    }



}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun CustomBottomNavigationPreview() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {    CustomBottomNavigation(navController,"", onItemSelected = {})
    }, content = {})
        

}