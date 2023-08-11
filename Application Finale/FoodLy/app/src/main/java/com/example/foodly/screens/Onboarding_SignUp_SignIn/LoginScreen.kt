package com.example.foodly.screens.Onboarding_SignUp_SignIn

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.component.Visibility
import com.example.foodly.component.VisibilityOff
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.*
import com.example.foodly.ui.theme.LightGreen
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun LoginScreen(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var showMessage by remember { mutableStateOf(false) }
    val gradientColor = listOf(LightGreen, Color.Black )
    val context = LocalContext.current
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
                    painter = painterResource(id = R.drawable.signin),
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
                        color = LightGreen
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //SimpleOutlinedTextFieldSample()
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
                    //SimpleOutlinedPasswordTextField()
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


                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp),
                        onClick = {
                            if (email.isEmpty()) {
                                Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
                            }else if(password.isEmpty()){
                                Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show()
                            }else if(password == "pass" && email == "admin"){
                                navController.navigate(Screen.DashBoard.route)
                            }else if(password == "resto_pass" && email == "admin_resto"){
                                navController.navigate(Screen.PageManagement.route)
                            }else if(email.isEmpty() && password.isEmpty()){
                                Toast.makeText(context, "Please enter password and password", Toast.LENGTH_SHORT).show()
                            }else{
                                try{
                                    val auth = Firebase.auth
                                    auth.signInWithEmailAndPassword(email, password)
                                        .addOnCompleteListener { task ->
                                            showMessage = if (task.isSuccessful){
                                                Log.d(TAG, "signInWithEmail: success")
                                                navController.navigate(Screen.CheckOutOrder.route){
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
                            }
                        },

                        contentPadding = PaddingValues(),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
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
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            androidx.compose.material3.Divider(modifier = Modifier.weight(1f))
                            androidx.compose.material3.Text(
                                text = "or continue with",
                                color = Color.Gray,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            androidx.compose.material3.Divider(modifier = Modifier.weight(1f))
                        }

                        SocialMediaSignInButtons(navController)
                        Column() {
                            Row(modifier = Modifier
                                .fillMaxWidth())
                            {
                                TextButton(onClick = { navController.navigate(Screen.RegisterScreen.route) }) {
                                    Spacer(modifier = Modifier.width(50.dp))
                                    Text(
                                        text = "Don't have an account? ",
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "Sign up",
                                        color = LightGreen
                                    )
                                }
                            }
                            Row(modifier = Modifier
                                .fillMaxWidth())
                            {
                                TextButton(onClick = { navController.navigate(Screen.ResetScreen.route) }) {
                                    Spacer(modifier = Modifier.width(44.dp))
                                    Text(
                                        text = "Forgot password? ",
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "Reset password",
                                        color = LightGreen
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun SocialMediaSignInButtons(navController: NavController) {
    val gradientColor = listOf(LightGreen, Color.Black )
    var user by remember { mutableStateOf(Firebase.auth.currentUser) }
    val launcher = rememberFirebaseAuthLauncher(
        onAuthComplete = { result ->
            user = result.user
            navController.navigate(Screen.CheckOutOrder.route)
        },

        onAuthError = {
            user = null
        }
    )

    val token = stringResource(id = R.string.default_web_client_did)
    val context = LocalContext.current


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Button(
                    onClick = {
                        val gso =
                            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                .requestIdToken(token)
                                .requestEmail()
                                .build()
                        val googleSignInClient = GoogleSignIn.getClient(context, gso)
                        launcher.launch(googleSignInClient.signInIntent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                    ),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                    modifier = Modifier
                        .clip(shape = Shapes.large)
                        .border(1.dp, LightGreen, RoundedCornerShape(10.dp)),
                    contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Google",
                        )
                    }
                }


        val navController = rememberNavController()

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            modifier = Modifier
                .clip(shape = Shapes.large)
                .border(1.dp, LightGreen, RoundedCornerShape(10.dp)),
            contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Facebook",
                )
            }
        }
    }
}

@Composable
fun Login() {
    var user by remember { mutableStateOf(Firebase.auth.currentUser) }
    val launcher = rememberFirebaseAuthLauncher(
        onAuthComplete = { result ->
            user = result.user
        },

        onAuthError = {
            user = null
        }
    )
    val token = stringResource(id = R.string.default_web_client_did)
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user == null) {
            Text("Not logged in")
            Button(onClick = {
                val gso =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(token)
                        .requestEmail()
                        .build()
                val googleSignInClient = GoogleSignIn.getClient(context, gso)
                launcher.launch(googleSignInClient.signInIntent)
            }) {
                Text("Sign in via Google")
            }
        } else {
            Text("Hi, ${user!!.displayName}!")
            Button(onClick = {
                Firebase.auth.signOut()
                user = null
            }) {
                Text("Log out")
            }
        }
    }
}

@Composable
fun rememberFirebaseAuthLauncher(
    onAuthComplete: (AuthResult) -> Unit,
    onAuthError: (ApiException) -> Unit
): ManagedActivityResultLauncher<Intent, ActivityResult> {
    val scope = rememberCoroutineScope()
    return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            Log.d("GoogleAuth", "account $account")
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            scope.launch {
                val authResult = Firebase.auth.signInWithCredential(credential).await()
                onAuthComplete(authResult)
            }
        } catch (e: ApiException) {
            Log.d("GoogleAuth", e.toString())
            onAuthError(e)
        }
    }
}