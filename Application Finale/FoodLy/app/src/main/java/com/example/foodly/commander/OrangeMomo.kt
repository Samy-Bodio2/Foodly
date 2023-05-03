package com.example.foodly.commander

import androidx.compose.foundation.Image
import com.example.foodly.ui.theme.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.foodly.R

@Composable
fun momoOM(navController : NavHostController){
    var mutateImg by remember { mutableStateOf(false)}
    var chifStr by remember { mutableStateOf("500.000")}
    var list = listOf("Credit Cart","Mobile Payement");
    var list2 = listOf("Orange Money","Mobile Money");
    var valeur by remember { mutableStateOf("")}
    var valeur1 by remember { mutableStateOf("")}
    var valeur2 by remember { mutableStateOf("")}
    var textFiledSize by remember { mutableStateOf(Size.Zero)}
    var expanded by remember { mutableStateOf(false) }
    var expanded1 by remember { mutableStateOf(false) }
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    val payIcon = if (!mutateImg){
        R.drawable.my_orange_96px
    }else{
        R.drawable.mtnfaux_96px
    }
    val colorText = if (!mutateImg){
        Color.White
    }else{
        Color.Black
    }
    val colorIcon = if (!mutateImg){
        orange2
    }else{
        yellow
    }
    val padlock = if (!mutateImg){
        R.drawable.padlock_white_32px
    }else{
        R.drawable.padlock_32px
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)){
        OutlinedTextField(value = valeur, onValueChange = {valeur = it},enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "selected payement mode") },//
            trailingIcon = {
                androidx.compose.material.Icon(
                    icon,
                    "",
                    Modifier.clickable { expanded = !expanded })
            })

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})) {
            list.forEach{mode ->                DropdownMenuItem(onClick = { valeur = mode
                if(mode == list[0]) navController.navigate("factu")
                expanded = false}){
                Text(text = mode);
            }
            }
        }

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(painterResource(payIcon),contentDescription = "", modifier = Modifier
                    .height(170.dp)
                    .width(170.dp))
            }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Payement amount");
        Spacer(modifier = Modifier.size(15.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(130.dp)){
            Text(text = chifStr,fontSize = 20.sp)
            //Spacer(modifier = Modifier.size(1000.dp))
            Button(modifier = Modifier
                .width(100.dp),                colors = ButtonDefaults.buttonColors(
                backgroundColor = colorIcon
            ), onClick = {navController.navigate("passComm")}){
                Text(text="Edit",color = colorText)
            }
        }
        OutlinedTextField(value = valeur1, onValueChange = {valeur1 = it},enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "Mobile payement mode") },//
            trailingIcon = {
                Icon(
                    icon,
                    "",
                    Modifier.clickable { expanded1 = !expanded1 })
            })
        DropdownMenu(expanded = expanded1, onDismissRequest = { expanded1 = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})) {
            list2.forEach{mode ->                DropdownMenuItem(onClick = { valeur1 = mode
                if(mode == list2[1]) mutateImg = true
                if(mode == list2[0]) mutateImg = false
                expanded1 = false}){
                Text(text = mode);
            }
            }
        }
       // Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(value = valeur2, onValueChange = {valeur2 = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "Phone Number") })
        Spacer(modifier = Modifier.size(15.dp))
        Button(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), onClick = {},colors = ButtonDefaults.buttonColors(
            backgroundColor = colorIcon
        )){
            Icon(painterResource(id = padlock),
                contentDescription = "", modifier = Modifier.clickable(enabled = false){ }, tint = colorText)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text="Pay  $"+chifStr,color = colorText)
        }
    }
}