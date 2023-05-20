package com.example.foodly.screens.Onboarding_SignUp_SignIn

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.*


@Composable
fun OtpVerifyScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else colorWhite)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
                    .background(colorWhite)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.otp_icon),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp, 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Verification code",
                color = colorBlack,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "\n" +
                        "We sent you a verification code to your\n" +
                        "mobile number\n",
                color = colorBlack,
                style = MaterialTheme.typography.button,
            )
            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Field(onValueChange = { old, new ->
                    if (new.length > 1 || new.any { !it.isDigit() }) old else new
                })
                Field(onValueChange = { old, new ->
                    if (new.length > 1 || new.any { !it.isDigit() }) old else new
                })
                Field(onValueChange = { old, new ->
                    if (new.length > 1 || new.any { !it.isDigit() }) old else new
                })
                Field(onValueChange = { old, new ->
                    if (new.length > 1 || new.any { !it.isDigit() }) old else new
                })
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = orange2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Submit \uD83D\uDE0B",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }

            TextButton(onClick = { }) {
                Text(
                    text = "Resend Verification code",
                    color = colorBlack,
                    fontSize = 14.sp,
                )
            }

        }

    }


}

@Composable
fun Field(
    modifier: Modifier = Modifier,
    onValueChange: (String, String) -> String = { _, new -> new }
) {

    val state = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier
            .requiredWidth(60.dp)
            .background(colorWhite)
            .border(
                width = 2.dp, color = colorBlack,
                shape = RoundedCornerShape(8.dp)
            )
            ,
        singleLine = true,
        value = state.value,
        onValueChange = {
            val value = onValueChange(state.value, it)
            state.value = value
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
    )


}

@Composable
@Preview
fun OtpVerifyScreenPreview() {
    OtpVerifyScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun OtpVerifyScreenDarkPreview() {
    OtpVerifyScreen(navController = NavController(LocalContext.current))

}
