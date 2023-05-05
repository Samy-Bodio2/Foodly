//package com.example.foodly.Inscription
//
//import android.graphics.Color
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import com.example.foodly.ui.theme.Color
////import androidx.compose.ui.graphics.
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.foodly.ui.theme.Theme
//
//@Composable
//fun SignUpScreen() {
//    var dropdownMenuExpanded by remember{ mutableStateOf(false) }
//    Surface(
//        color = Color.WHITE,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.restaurant_x),
//                contentDescription = null,
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(32.dp))
//
//            var nom by remember {
//                mutableStateOf("")
//            }
//            var prenom by remember {
//                mutableStateOf("")
//            }
//            TextField(
//                value = nom,
//                onValueChange = {
//                    nom = it
//                },
//                label = { Text("Nom") },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Magenta
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            TextField(
//                value = prenom,
//                onValueChange = {
//                    prenom = it
//                },
//                label = { Text("Prénom") },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Magenta
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(25.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                RadioButton(
//                    selected = true,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = Color.Magenta,
//                        unselectedColor = Color.Black
//                    ),
//                )
//                Text(
//                    text = "Femme",
//                    style = MaterialTheme.typography.body1,
//                    color = Color.Black,
//                    modifier = Modifier.padding(start = 8.dp)
//                )
//                Spacer(modifier = Modifier.width(50.dp))
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = Color.Magenta,
//                        unselectedColor = Color.Black
//                    ),
//                )
//                Text(
//                    text = "Homme",
//                    style = MaterialTheme.typography.body1,
//                    color = Color.Black,
//                    modifier = Modifier.padding(start = 8.dp)
//                )
//            }
//            Spacer(modifier = Modifier.height(32.dp))
//
//            var selectedSexe by remember { mutableStateOf("Homme") }
//            val sexes = listOf("Homme", "Femme", "Non-binaire")
//
//            Box(modifier = Modifier.width(200.dp)) {
//                Text(text = selectedSexe, modifier = Modifier.clickable(onClick = {
//                    // Ouvre le menu déroulant lorsqu'on clique sur le texte
//                    dropdownMenuExpanded = true
//                }))
//
//                DropdownMenu(
//                    expanded = dropdownMenuExpanded,
//                    onDismissRequest = { dropdownMenuExpanded = false },
//                    modifier = Modifier.width(200.dp)
//                ) {
//                    sexes.forEachIndexed { index, sexe ->
//                        DropdownMenuItem(
//                            onClick = {
//                                selectedSexe = sexe
//                                dropdownMenuExpanded = false
//                            }
//                        ) {
//                            Text(text = sexe)
//                        }
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.height(32.dp))
//
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.padding(start =20.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = Color.Magenta,
//                    contentColor = Color.White
//                )
//            ) {
//                Text(text = "S'inscrire")
//            }
//        }
//    }
//}
//
