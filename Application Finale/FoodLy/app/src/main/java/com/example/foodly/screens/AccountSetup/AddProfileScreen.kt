package com.example.foodly.screens.AccountSetup

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.screens.Onboarding_SignUp_SignIn.BorderButton
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.md_theme_dark_onSecondaryContainer
import com.example.foodly.ui.theme.metropolisFontFamily
import com.example.foodly.ui.theme.primaryFontColor


@Composable
fun AddProfileScreen(navController: NavController) {
    TopBar()
    Spacer(modifier = Modifier.padding(0.dp))

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
                painter = painterResource(id = R.drawable.user_img),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .padding(top = 70.dp)


            )
            val gradientColor = listOf(Color(0xFF30A235), Color(0xFF30A235))
            val cornerRadius = 2.dp
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                //   .verticalScroll(rememberScrollState())
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    EditImage()
                    Spacer(modifier = Modifier.padding(8.dp))

                }

                item {
                    RegisterFullnane()
                    Spacer(modifier = Modifier.padding(8.dp))

                }
                item {
                    RegisterNickName()
                    Spacer(modifier = Modifier.padding(8.dp))

                }
                item {
                    RegisterEmail()
                    Spacer(modifier = Modifier.padding(8.dp))

                }
                item {
                    RegisterPhone()
                    Spacer(modifier = Modifier.padding(8.dp))

                }
                item {
                    Gender()
                    Spacer(modifier = Modifier.padding(8.dp))

                }

                item{
                    GradientButton(
                        gradientColors = gradientColor,
                        cornerRadius = cornerRadius,
                        nameButton = "Continue",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp , topEnd = 30.dp, bottomStart = 30.dp),
                        navController
                    )

                    GradientButton(
                        gradientColors = gradientColor,
                        cornerRadius = cornerRadius,
                        nameButton = "Skip",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp , topEnd = 30.dp, bottomStart = 30.dp),
                        navController
                    )


                }
                item{
                    TextButton(onClick = {
                        navController.navigate(Screen.HomeScreen.route){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true

                        }

                    }) {

                    }
                }

            }
        }
    }
}

@Composable
private fun GradientButton(
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    roundedCornerShape: RoundedCornerShape,
    navController: NavController
) {

    androidx.compose.material3.Button(

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            navController.navigate(Screen.HomeScreen.route)
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
fun RegisterFullnane() {

    var text by rememberSaveable { mutableStateOf("") }
//    shape = roundedCornerShape(8.dp)
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text =  "First Name") },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(15.dp)),

        keyboardActions = KeyboardActions(
            onDone = {
            }
        ),


        )
}
@Composable
fun RegisterNickName() {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        placeholder = { Text(text = "Last Name")},

        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }
        )

    )
}

@Composable
fun RegisterPhone() {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        placeholder = { Text(text = "+237 00 00 00 00") },
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
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {
            }
        )
    )
}
@Composable
fun EditImage(){

    Box (
        modifier = Modifier
            .padding(top = 140.dp, start = 70.dp)
            .width(30.dp)
            .height(30.dp)
            .background(Color(0xFF30A235))
            .clip(RoundedCornerShape(20.dp)),
        Alignment.Center


    ){
        Image(
            painter = painterResource(id = R.drawable.arrow_left), contentDescription = null,
            modifier = Modifier
                .height(100.dp)
        )
    }
}
@Composable
fun BorderIcon(editImage: Unit ) {
    Box(
        Modifier.fillMaxSize()
            .background(Color.Transparent)
    ){
        Box(
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .background(Color(0xFF30A235))

        ) {

        }
    }



}

@Composable
fun RegisterEmail() {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        placeholder = { Text(text = "youradress@.com") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = md_theme_dark_onSecondaryContainer,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(15.dp)),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        )
    )
}



@Composable
fun TopBar() {
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
            text = "Fill Your Profil",
            style = TextStyle(
                color = primaryFontColor,
                fontSize = 20.sp,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )

    }
}

@Composable
fun Gender() {
    var selectedFood by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var list = listOf("Masculin", "Feminin")
    var selectedFood1 : List<String> = listOf("")
    var enabled by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("")}
    var textFiledSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }



    Column(modifier = Modifier.padding(20.dp)

    ) {

        OutlinedTextField(value = selectedItem, onValueChange = {selectedItem = it},
            enabled = false,
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,


                ),

            modifier = Modifier
                .fillMaxWidth(0.9f)

                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = {Text(text = "Gender")},
            trailingIcon = {
                Icon(icon,"",Modifier.clickable{expanded = !expanded})
            })

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },//
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})//
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = { selectedItem = label
                    selectedFood1 = getGender(selectedItem)
                    selectedFood = selectedFood1[0];
                    expanded = false
                    enabled = true
                }) {
                    Text(text = label)
                }
            }
        }
    }
}
fun getGender(category: String): List<String> {
    return when (category) {
        "Masculin" -> listOf("M", "F", "null")
        "Feminin" -> listOf("F", "M", "Neutre")

        else -> emptyList()
    }
}

@Preview
@Composable
fun Preview2ss() {
    val navController = rememberNavController()
    AddProfileScreen(navController)
}

