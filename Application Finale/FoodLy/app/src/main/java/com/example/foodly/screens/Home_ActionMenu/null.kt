//package com.example.foodly.screens.Home_ActionMenu
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.foodly.read
//
////
////@Composable
////fun lazyItems(){
////    val list by remember { mutableStateOf(read()) }
////    Column(
////        modifier = Modifier
////            .fillMaxSize()
////            .padding(horizontal = 16.dp, vertical = 20.dp)
////    ) {
////        list.forEach {  item ->
////
////            item?.let {
////                MenuList(
////                    url = it.Image,
////                    titre = it.name,
////                    restauName = it.restaurant_name,
////                    price = it.price
////                )
////                Spacer(modifier = Modifier.height(20.dp))
////            }
////        }
////    }
//}