package com.example.foodly.screens.Onboarding_SignUp_SignIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Let_You_In(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcome),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
                Text(
                    text = "Let's you in",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
                SocialButton(iconId = R.drawable.ic_facebook, label = "Continue with Facebook")
                SocialButton(iconId = R.drawable.ic_google, label = "Continue with Google")
                SocialButton(iconId = R.drawable.apple, label = "Continue with Apple")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(text = "or", color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
                    Divider(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate(Screen.LoginScreen.route)
                    },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(LightGreen)
                ) {
                    Text(text = "Sign in with email", color = Color.White)
                }
                Row{
                    Text(
                        text = "Don't have an account?",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    TextButton(onClick = { navController.navigate(Screen.RegisterScreen.route) }) {
                        Text(text = "Sign up", color = LightGreen)
                    }
                }
            }
        }
    )
}

@Composable
fun SocialButton(iconId: Int, label: String) {
    val navController = rememberNavController()
    OutlinedButton(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            Color.White,
            contentColor = Color.Black
        )
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(text = label, modifier = Modifier.padding(start = 8.dp))
    }
}