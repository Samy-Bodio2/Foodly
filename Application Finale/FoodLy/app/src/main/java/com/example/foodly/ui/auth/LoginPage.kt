package com.example.foodly.ui.auth

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginPage(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var showMessage by remember { mutableStateOf(false) }
    val gradientColor = listOf(Color(0xFFF15C48), Color(0xFFF16356))
    val cornerRadius = 16.dp

    Surface {

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
                    painter = painterResource(id = R.drawable.user_reg),
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
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //SimpleOutlinedTextFieldSample()
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
                        label = {
                            Text("Name or Email Address",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            ) },
                        placeholder = { Text(text = "Name or Email Address") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.primary),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()

                            }
                        )

                    )

                    Spacer(modifier = Modifier.padding(3.dp))
                    //SimpleOutlinedPasswordTextField()
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
                        label = {
                            Text("Enter Password",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            ) },
                        visualTransformation =
                        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.primary),
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


                    Spacer(modifier = Modifier.padding(10.dp))
                    androidx.compose.material3.Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp),
                        onClick = {
                            try{
                                val auth = Firebase.auth
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        showMessage = if (task.isSuccessful){
                                            Log.d(TAG, "signInWithEmail: success")
                                            navController.navigate("homescreen"){
                                                popUpTo(navController.graph.startDestinationId)
                                                launchSingleTop = true
                                            }
                                            false
                                        }else{
                                            Log.w(TAG, "signInWithEmail:failure")
                                            true
                                        }
                                    }
                            }catch (e: Exception) {
                                println("Erreur : $e.message")
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
                                text = "Login",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    }

                    if (showMessage) {
                        AlertDialog(
                            onDismissRequest = { showMessage = false },
                            title = { Text("Authentification invalide") },
                            text = {
                                Text("Email ou mot de passe incorrect")
                            },
                            confirmButton = {
                                androidx.compose.material3.Button(
                                    onClick = { showMessage = false }
                                ) {
                                    Text("OK")
                                }
                            }
                        )
                    }
                    GradientButton(
                        navController,
                        gradientColors = gradientColor,
                        cornerRadius = cornerRadius,
                        nameButton = "Login",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    androidx.compose.material3.TextButton(onClick = {

                        navController.navigate("register_page") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }) {
                        androidx.compose.material3.Text(
                            text = "Create An Account",
                            letterSpacing = 1.sp,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }


                    Spacer(modifier = Modifier.padding(5.dp))
                    androidx.compose.material3.TextButton(onClick = {

                        navController.navigate("reset_page") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }) {
                        androidx.compose.material3.Text(
                            text = "Reset Password",
                            letterSpacing = 1.sp,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun GradientButton(
    navController: NavController,
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    roundedCornerShape: RoundedCornerShape
) {



}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleOutlinedTextFieldSample() {
    //var email by rememberSaveable { mutableStateOf("") }


}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleOutlinedPasswordTextField() {
    val keyboardController = LocalSoftwareKeyboardController.current

}

/*
@Preview(showBackground = true)
@Composable
fun PreviewPasswordTextField() {
    SimpleOutlinedPasswordTextField()
}*/
/*
@Preview(showBackground = true)
@Composable
fun LoginPage() {
    LoginPage(navController = rememberNavController())
    //Log ()
}*/
