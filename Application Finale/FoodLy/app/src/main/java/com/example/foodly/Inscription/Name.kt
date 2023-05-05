package com.example.foodly.Inscription

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Name(navController: NavController){
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
                    text = "Enter your first name",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h6,
                    //color = MaterialTheme.colorScheme.primary,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Firstname()
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Enter your last name",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Lastname()
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Enter your user name",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(top = 13.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Username()

                SexSelectionScreen()

                val gradientColor = listOf(Color(0xFFF15C48), Color(0xFFF16356))
                val cornerRadius = 16.dp


                Spacer(modifier = Modifier.padding(10.dp))
                ButtonName(navController,
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
private fun ButtonName(navController: NavController,
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
            navController.navigate("email") {
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
fun Firstname() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var first_name by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = first_name,
        onValueChange = { first_name = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        label = {
            Text("First name",
                //color = MaterialTheme.colorScheme.scrim,
                //style = MaterialTheme.typography.labelMedium,
            ) },
        placeholder = { Text(text = "First name") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        )
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Lastname() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var last_name by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = last_name,
        onValueChange = { last_name = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        label = {
            Text("Name",
                //color = MaterialTheme.colorScheme.scrim,
                //style = MaterialTheme.typography.labelMedium,
            ) },
        placeholder = { Text(text = "Name") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        )
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Username() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = phoneNumber,
        onValueChange = { phoneNumber = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),
        label = {
            Text("Username",
                //color = MaterialTheme.colorScheme.scrim,
                //style = MaterialTheme.typography.labelMedium,
            ) },
        placeholder = { Text(text = "Username") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        )
    )
}

@Composable
fun SexSelectionScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Sexe",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        var selectedOption by remember { mutableStateOf(SexOption.Male) }

        RadioGroup(
            options = listOf(
                SexOption.Male,
                SexOption.Female,
                SexOption.Other
            ),
            selectedOption = selectedOption,
            onOptionSelected = { option ->
                selectedOption = option
            }
        )
    }
}

enum class SexOption(val label: String) {
    Male("Homme"),
    Female("Femme"),
    Other("Autre")
}

@Composable
fun RadioGroup(
    options: List<SexOption>,
    selectedOption: SexOption,
    onOptionSelected: (SexOption) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (option == selectedOption),
                        onClick = { onOptionSelected(option) }
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null // null recommended for accessibility with selects
                )
                Text(
                    text = option.label,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}