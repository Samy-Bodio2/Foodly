package com.example.foodly.commander

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import com.example.foodly.R
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

@Composable
fun facturation(navController : NavHostController){
//    var chifStr : String = "500.000";
    var chifStr by remember { mutableStateOf("500.000")}
    var valeur by remember { mutableStateOf("")}
    var valeur2 by remember { mutableStateOf("")}
    var valeur3 by remember { mutableStateOf("")}
    var valeur4 by remember { mutableStateOf("")}
    var valeur5 by remember { mutableStateOf("")}
    var valeur6 by remember { mutableStateOf("")}
    var textFiledSize by remember { mutableStateOf(Size.Zero)}
    var expanded by remember { mutableStateOf(false)}
    var list = listOf("Credit Card","MoMo","Orange Money");
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()) {
        OutlinedTextField(value = valeur, onValueChange = {valeur = it},enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "selected payement mode") },//
            trailingIcon = {
                Icon(
                    icon,
                    "",
                    Modifier.clickable { expanded = !expanded })
            })

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current){textFiledSize.width.toDp()})) {
        list.forEach{mode ->                DropdownMenuItem(onClick = { valeur = mode
            expanded = false}){
            Text(text = mode);
        }
        }
    }
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Payement amount");
        Spacer(modifier = Modifier.size(15.dp))

    Row(horizontalArrangement = Arrangement.spacedBy(130.dp)){
        Text(text = chifStr,fontSize = 20.sp)
        //Spacer(modifier = Modifier.size(1000.dp))
        Button(modifier = Modifier
            .width(100.dp), onClick = {navController.navigate("passComm")}){
            Text(text="Edit")
        }
    }
        OutlinedTextField(value = valeur2, onValueChange = {valeur2 = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "Name on card") })
        
        OutlinedTextField(value = valeur3, onValueChange = {valeur3 = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "Card number") },
            trailingIcon = {
                Row(){
                    Image(
                        painterResource(id = R.drawable.visa_32px),
                        contentDescription = "", modifier = Modifier.clickable (enabled = false){ })

                         Image(
                             painterResource(id = R.drawable.mastercard_logo_32px),
                        contentDescription = "", modifier = Modifier.clickable(enabled = false){ })
                }
            }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(100.dp)){
            Text(text="Expiry date");
            Text(text = "Security code")
        }
        Row(modifier = Modifier.fillMaxWidth()){
            OutlinedTextField(value = valeur4, onValueChange = {valeur4 = it},
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .onGloballyPositioned { coordinates ->
                        textFiledSize = coordinates.size.toSize()
                    },
                label = { Text(text = "MM/YY") })
            OutlinedTextField(value = valeur5, onValueChange = {valeur5 = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFiledSize = coordinates.size.toSize()
                    },
                label = { Text(text = "") },
            trailingIcon ={
                Image(
                   painterResource(id = R.drawable.question_mark_32px),
                        contentDescription = "", modifier = Modifier.clickable(enabled = false){ })

            })
        }
        OutlinedTextField(value = valeur6, onValueChange = {valeur5 = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = "ZIP/Postal code") },
            trailingIcon ={
                Image(
                    painterResource(id = R.drawable.question_mark_32px),
                    contentDescription = "", modifier = Modifier.clickable(enabled = false){ })

            })
        Spacer(modifier = Modifier.size(20.dp))
        Button(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), onClick = {}){
            Icon(painterResource(id = R.drawable.padlock_32px),
                contentDescription = "", modifier = Modifier.clickable(enabled = false){ })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text="Pay  $"+chifStr)
        }
}
}


