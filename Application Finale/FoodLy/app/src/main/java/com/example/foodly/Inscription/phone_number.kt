/*package com.example.foodly.Inscription
/*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun Phone_number(navController: NavController){
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }
    val db = Firebase.firestore
    val customerCollectionRef = db.collection("Customer")

    fun SaveCustomer() {
        // Créer un nouveau document avec le username renseigné
        val newCustomer = hashMapOf(
            "first_name" to phoneNumber,

        )

        // Ajouter le nouveau document à la collection "customer"
        customerCollectionRef.add(newCustomer)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {
        Image(
            painter = painterResource(id = com.example.foodly.R.drawable.image1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize(),

            )


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //.........................Spacer
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Enter your phone number",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h6,
                    //color = MaterialTheme.colorScheme.primary,
                )
                Spacer(modifier = Modifier.height(6.dp))


                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
                    label = {
                        Text("Phone number",
                            //color = MaterialTheme.colorScheme.scrim,
                            //style = MaterialTheme.typography.labelMedium,
                        ) },
                    placeholder = { Text(text = "Phone number") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    )
                )


                val gradientColor = listOf(Color(0xFFF15C48), Color(0xFFF16356))
                val cornerRadius = 16.dp


                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    onClick = {
                        if (phoneNumber.startsWith("6") && phoneNumber.length == 9 || phoneNumber.isEmpty()) {
                            SaveCustomer()
                            navController.navigate("password") {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        } else {
                            showErrorDialog = true
                        }

                    },

                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    shape = RoundedCornerShape(cornerRadius)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(colors = gradientColor),
                                shape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp)
                            )
                            .clip(RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Suivant",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

                if (showErrorDialog) {
                    AlertDialog(
                        onDismissRequest = { showErrorDialog = false },
                        title = { Text("Invalid Phone Number") },
                        text = { Text("Please enter a valid phone number starting with 6 and having 9 digits.") },
                        confirmButton = {
                            Button(onClick = { showErrorDialog = false }) {
                                Text("OK")
                            }
                        }
                    )
                }
            }
        }
    }
}*/