@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.foodly.Log

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.ui.theme.orange
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.graphics.Color
import com.example.foodly.ui.theme.colorBlack
import com.example.foodly.ui.theme.md_theme_light_primary

@Composable
fun Email(navController: NavController) {
    val image = painterResource(id = R.drawable.email_log)

    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(androidx.compose.ui.graphics.Color.White), contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }

      /*  Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
               // .clip(RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp))
                .background(Color.)
                .padding(10.dp)
        ) {
            ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))*/
        Column(
            modifier = Modifier
                // .padding(16.dp)
                .padding(10.dp)
                .fillMaxWidth()
                //
                .fillMaxHeight(0.60f)
                .verticalScroll(rememberScrollState()),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            androidx.compose.material3.Text(
                text = "Sign In",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 130.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                //color = MaterialTheme.colorScheme.primary,
                 color = orange
            )
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.padding(3.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue,
                        onValueChange = { emailValue = it },
                        label = { Text("Email Address") },
                        placeholder = { Text("Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            focusRequester.requestFocus()
                        })
                    )

                    OutlinedTextField(
                        value = passwordValue,
                        onValueChange = { passwordValue = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye),
                                    contentDescription = null,
                                    tint = if (passwordVisibility) androidx.compose.ui.graphics.Color.Blue else androidx.compose.ui.graphics.Color.Gray
                                )
                            }
                        },
                        label = { Text("Password") },
                        placeholder = { Text("Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            //LocalSoftwareKeyboardController.current?.hideSoftwareKeyboard()
                        })
                    )


                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                      //colors = ButtonDefaults.buttonColors(backgroundColor = orange )
                    ) {
                        Text(text = "Sign In", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Create An Account",
                        color = orange,
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate("register_page"){
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun Email() {
    Email(navController = rememberNavController())
    //Log ()
}