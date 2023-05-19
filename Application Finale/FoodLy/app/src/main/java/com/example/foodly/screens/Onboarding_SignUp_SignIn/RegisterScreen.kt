package com.example.foodly.screens.Onboarding_SignUp_SignIn

import android.util.Patterns
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.foodly.R
import com.example.foodly.component.Visibility
import com.example.foodly.component.VisibilityOff
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.colorBlack
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
import org.mindrot.jbcrypt.BCrypt
import java.util.*

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var showDialog by remember { mutableStateOf(false) }
    var username by rememberSaveable { mutableStateOf("") }
    var conpassword by rememberSaveable { mutableStateOf("") }
    var passwordHidde by rememberSaveable { mutableStateOf(true) }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val gradientColor = listOf(LightGreen, Black)
    val cornerRadius = 16.dp
    var showDialogUsername by remember { mutableStateOf(false) }
    var showDialogEmail by remember { mutableStateOf(false) }
    var showDialogPhoneNumber by remember { mutableStateOf(false) }
    var showDialogPassWord by remember { mutableStateOf(false) }



    /*val db = Firebase.firestore
    val start_date = Date()
    val customerCollectionRef = db.collection("Customers")
    val passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12))

    fun SaveCustomer() {
        // Créer un nouveau document avec le username renseigné
        val newCustomer = hashMapOf(
            "username" to username,
            "email" to email,
            "phone_number" to phoneNumber,
            "password" to passwordHash,
            "start_date" to start_date
        )

        // Ajouter le nouveau document à la collection "customer"
        customerCollectionRef.add(newCustomer)
    }
*/
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {

            Image(
                painter = painterResource(id = R.drawable.signup),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),

                )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //.........................Spacer
                Spacer(modifier = Modifier.height(30.dp))

                //.........................Text: title
                androidx.compose.material3.Text(
                    text = "Create An Account",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 130.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = LightGreen,
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    shape = RoundedCornerShape(20.dp),
                    label = {
                        Text("Name",
                            color = MaterialTheme.colorScheme.scrim,
                            style = MaterialTheme.typography.labelMedium,
                        ) },
                    placeholder = { Text(text = "Name") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    ),
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGreen,
                        unfocusedBorderColor = LightGreen),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )

                )

                Spacer(modifier = Modifier.padding(3.dp))

                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {
                        Row(
                            modifier = Modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.cameroon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(24.dp, 24.dp)
                                        .padding(start = 10.dp)
                                )
                                Text(
                                    text = "+237",
                                    color = colorBlack,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                                Canvas(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .padding(start = 10.dp)
                                ) {
                                    drawLine(
                                        color = Color.Gray,
                                        start = Offset(0f, 0f),
                                        end = Offset(0f, size.height),
                                        strokeWidth = 2.0F
                                    )
                                }
                            }
                        )
                    },
                    label = {
                        Text("Phone",
                            color = MaterialTheme.colorScheme.scrim,
                            style = MaterialTheme.typography.labelMedium,
                        ) },
                    placeholder = { Text(text = "Phone") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Phone
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGreen,
                        unfocusedBorderColor = LightGreen),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )

                Spacer(modifier = Modifier.padding(3.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(20.dp),
                    label = {
                        Text("Email Address",
                            color = MaterialTheme.colorScheme.scrim,
                            style = MaterialTheme.typography.labelMedium,
                        ) },
                    placeholder = { Text(text = "Email Address") },
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Password") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Email
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGreen,
                        unfocusedBorderColor = LightGreen),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )


                Spacer(modifier = Modifier.padding(3.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password") },
                    label = {
                        Text("Enter Password",
                            color = MaterialTheme.colorScheme.scrim,
                            style = MaterialTheme.typography.labelMedium,
                        ) },
                    visualTransformation =
                    if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Password
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGreen,
                        unfocusedBorderColor = LightGreen),
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            val visibilityIcon =
                                if (passwordHidden) Visibility else VisibilityOff
                            val description = if (passwordHidden) "Show password" else "Hide password"
                            Icon(imageVector = visibilityIcon, contentDescription = description)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )

                Spacer(modifier = Modifier.padding(3.dp))

                OutlinedTextField(
                    value = conpassword,
                    onValueChange = { conpassword = it },
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = { Icon(Icons.Filled.Password, contentDescription = "Password") },
                    label = {
                        Text("Confirm Password",
                            color = MaterialTheme.colorScheme.scrim,
                            style = MaterialTheme.typography.labelMedium,
                        ) },
                    visualTransformation =
                    if (passwordHidde) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGreen,
                        unfocusedBorderColor = LightGreen),
                    trailingIcon = {
                        IconButton(onClick = { passwordHidde = !passwordHidde }) {
                            val visibilityIcon =
                                if (passwordHidde) Visibility else VisibilityOff
                            val description = if (passwordHidde) "Show password" else "Hide password"
                            Icon(imageVector = visibilityIcon, contentDescription = description)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )


                Spacer(modifier = Modifier.padding(10.dp))
                androidx.compose.material3.Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    onClick = {
                        if (username.isEmpty()) {
                            showDialogUsername = true
                        }else if(email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                            showDialogEmail = true
                        }else if(phoneNumber.startsWith("6") && phoneNumber.length == 9 || phoneNumber.isEmpty()){
                            showDialogPhoneNumber = false
                        }else if(password.isEmpty() || conpassword.isEmpty() || password != conpassword || password.length >= 8 || conpassword.length >= 8){
                            showDialogPassWord = true
                        }else {
                           // SaveCustomer()
                            //createUser(email, password, navController)
                        }
                    },


                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(cornerRadius)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(colors = gradientColor),
                                shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp)
                            )
                            .clip(RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        androidx.compose.material3.Text(
                            text = "Create An Account",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

                if(showDialog){
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Adresse e-mail invalide") },
                        text = { Text("L'adresse e-mail saisie est invalide.") },
                        confirmButton = {
                            Button(
                                onClick = { showDialog = false },
                            ) {
                                Text("OK")
                            }
                        }
                    )
                }

                if (showDialogUsername) {
                    BackHandler {
                        showDialogUsername = false
                    }
                    androidx.compose.material.AlertDialog(
                        onDismissRequest = { showDialogUsername = false },
                        title = { Text("Erreur") },
                        text = { Text("Champ vide") },
                        buttons = {
                            Button(
                                onClick = { showDialogUsername = false }
                            ) {
                                Text("OK")
                            }
                        },
                        backgroundColor = Color.White
                    )
                }

                if (showDialogEmail) {
                    androidx.compose.material.AlertDialog(
                        onDismissRequest = { showDialogEmail = false },
                        title = { Text("Erreur") },
                        text = { Text("L'email n'est pas valide") },
                        confirmButton = {
                            Button(onClick = { showDialogEmail = false }) {
                                Text("OK")
                            }
                        }
                    )
                }

                if (showDialogPhoneNumber) {
                    androidx.compose.material.AlertDialog(
                        onDismissRequest = { showDialogPhoneNumber = false },
                        title = { Text("Invalid Phone Number") },
                        text = { Text("Please enter a valid phone number starting with 6 and having 9 digits.") },
                        confirmButton = {
                            Button(onClick = { showDialogPhoneNumber = false }) {
                                Text("OK")
                            }
                        }
                    )
                }

                if (showDialogPassWord) {
                    androidx.compose.material.AlertDialog(
                        onDismissRequest = { showDialogPassWord = false },
                        title = { Text("Erreur") },
                        text = { Text("Les mots de passe ne correspondent pas ou sont vides.") },
                        confirmButton = {
                            Button(
                                onClick = { showDialogPassWord = false }
                            ) {
                                Text("OK")
                            }
                        }
                    )
                }
                Row{
                    androidx.compose.material3.Text(
                        text = "Don't have an account?",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    androidx.compose.material3.TextButton(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
                        androidx.compose.material3.Text(
                            text = "Sign in",
                            color = LightGreen
                        )
                    }
                }
            }
        }
    }
}

/*
fun createUser(
    email: String,
    password: String,
    navController: NavController

){
    println("L'email est $email, et le mot de passe est $password")

    val auth = Firebase.auth
    try {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    navController.navigate(Screen.HomeScreen.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    } // naviguer vers la page de connexion


                } else {
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                }
            }
    } catch (e: Exception) {
        println("Erreur : $e.message")
    }
}*/