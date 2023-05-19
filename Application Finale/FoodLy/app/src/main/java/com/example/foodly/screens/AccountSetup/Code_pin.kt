package com.example.foodly.screens.AccountSetup


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.ui.theme.md_theme_dark_onSecondaryContainer
import com.example.foodly.ui.theme.metropolisFontFamily
import com.example.foodly.ui.theme.primaryFontColor


@Composable
fun codePin(navController: NavController) {
    TopBars()
    Spacer(modifier = Modifier.padding(0.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 300.dp)
            .background(
                color = Color.Transparent,
            ),
        contentAlignment =Alignment.Center


    ) {


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {

            Column(
                modifier = Modifier

                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "add a PIN number to make your accout more secure",
                        style = TextStyle(
                            color = primaryFontColor,
                            fontSize = 20.sp,
                            fontFamily = metropolisFontFamily,
                            textAlign = TextAlign.Center

                        )
                    )

                }
                Spacer(modifier = Modifier.padding(30.dp))
                Row(

                    modifier = Modifier
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.Center

                ){
                    RegisterPhones()
                    Spacer(modifier = Modifier.width(3.dp))
                    RegisterPhone2()
                    Spacer(modifier = Modifier.width(3.dp))
                    RegisterPhones3()
                    Spacer(modifier = Modifier.width(3.dp))
                    RegisterPhones4()
                }



                val gradientColor = listOf(Color(0xFF0FDD61), Color(0xFF0FDD61))
                val cornerRadius = 2.dp

                Spacer(modifier = Modifier.padding(10.dp))
                GradientButton(
                    gradientColors = gradientColor,
                    cornerRadius = cornerRadius,
                    nameButton = "Continue",
                    roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp , topEnd = 30.dp, bottomStart = 30.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))
                androidx.compose.material3.TextButton(onClick = {
                    navController.navigate("login_page"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true

                    }

                }) {

                }

                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}

@Composable
private fun GradientButton(
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    roundedCornerShape: RoundedCornerShape
) {

    androidx.compose.material3.Button(

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {

        },

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(15.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),

                    )
//                .clip(roundedCornerShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}



@Composable
fun RegisterPhones() {
//    val keyboardController = LocalSoftwareKeyboardController.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(

        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text = "0") },
//         if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        ),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,

            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.2f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }


        )
    )
}
@Composable
fun RegisterPhone2() {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text = " 0") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,

            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.2f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }
        )
    )
}
@Composable
fun RegisterPhones3() {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text = "0") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,

            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.2f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }
        )
    )
}
@Composable
fun RegisterPhones4() {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text = "0") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,

            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.2f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }
        )
    )
}


@Composable
fun TopBars() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(id = R.drawable.left_arrow_50px),
            modifier = Modifier
                .width(width = 50.dp),
            contentDescription = null,
            tint = primaryFontColor,

            )
        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Create New PIN",
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 20.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )

    }
}

@Preview
@Composable
fun Preview2sse(){
    val navController = rememberNavController()
    codePin(navController)
}