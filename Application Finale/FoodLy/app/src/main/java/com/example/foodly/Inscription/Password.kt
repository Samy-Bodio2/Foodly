package com.example.foodly.Inscription

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import com.example.foodly.ui.auth.Visibility
import com.example.foodly.ui.auth.VisibilityOff



@Composable
fun PasswordScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {

        BorderButton(R.drawable.go_back_24px)
    }

}

@Composable
fun BorderButton(
    @DrawableRes iconResouce: Int,
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}


@Composable
fun Content(){
    LazyColumn(contentPadding = PaddingValues(top = 300.dp) ){
        item {

            PasswordTextField()
            NexButton()
        }
    }

}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordTextField() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    Text(
        text = "Enter your password",
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 19.dp)    )

    OutlinedTextField(

        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        label = {
            Text("Password",  color = MaterialTheme.colorScheme.scrim,)
        },
        placeholder = {
            Text(text = "Minimun 8 charactere")
        },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Red,
            unfocusedIndicatorColor = Red,
            backgroundColor = White
        ),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val voirIcone =
                    if (passwordHidden) Visibility else VisibilityOff
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = voirIcone, contentDescription = description)
            }
        },
        modifier = Modifier.fillMaxWidth(1f).padding(horizontal = 17.dp)  ,

        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}
@Composable
fun NexButton() {
    Button(
        onClick = { /*TODO*/ },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Red,
            contentColor = White
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(17.dp)
    ) {
        Text(text = "Suivant", modifier = Modifier.padding(10.dp))
    }

}



@Preview(showBackground = true)
@Composable
fun PreviewPasswordTextField() {
    PasswordScreen()
    Content()

}


