package com.example.foodly.Inscription

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

@Composable
fun Phone_number(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {
        Image(
            painter = painterResource(id = com.example.foodly.R.drawable.image4),
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
                PhoneNumberInputScreen()


                val gradientColor = listOf(Color(0xFFF15C48), Color(0xFFF16356))
                val cornerRadius = 16.dp


                Spacer(modifier = Modifier.padding(10.dp))
                ButtonPhone(navController,
                    gradientColors = gradientColor,
                    cornerRadius = cornerRadius,
                    nameButton = "Suivant",
                    roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
private fun ButtonPhone(navController: NavController,
                        gradientColors: List<Color>,
                        cornerRadius: Dp,
                        nameButton: String,
                        roundedCornerShape: RoundedCornerShape
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            navController.navigate("password") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
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
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PhoneNumber() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var phoneNumber by rememberSaveable { mutableStateOf("") }

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
}

@Composable
fun PhoneNumberInputScreen() {
    // Définir les états des champs de saisie
    val phoneNumber = remember { mutableStateOf(TextFieldValue()) }
    val country = remember { mutableStateOf("+237") }

    Row() {

        // Champ de saisie du numéro de téléphone
        CountrySelectionDropdown(
            selectedCountry = country.value,
            countries = listOf("+237", "+1", "+44"),
            onCountrySelected = { country.value = it }
        )
        OutlinedTextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(text = "  Phone number") },
        )
    }
}

@Composable
fun CountrySelectionDropdown(
    selectedCountry: String,
    countries: List<String>,
    onCountrySelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Column(Modifier.width(150.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = selectedCountry, modifier = Modifier.clickable(onClick = { expanded = true }))
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable(onClick = { expanded = true })
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(150.dp)
            ) {
                countries.forEach { country ->
                    DropdownMenuItem(
                        onClick = {
                            onCountrySelected(country)
                            expanded = false
                        }
                    ) {
                        Text(text = country)
                    }
                }
            }
        }
    }
}