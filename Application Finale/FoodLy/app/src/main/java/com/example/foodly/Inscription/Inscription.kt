package com.example.foodly.Inscription
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.R



@Composable
fun Name() {

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

        BordureButtons(R.drawable.go_back_24pxs)
    }

}

@Composable
fun BordureButtons(
    @DrawableRes iconResouce: Int,
    color: Color = Color.Gray,
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
fun Contents(){
    LazyColumn(contentPadding = PaddingValues(top = 300.dp) ){
        item {

            NamesrdTextField()
            LastNamerdTextField()
            SexeTextField()
        }
    }

}


@Composable
fun NamesrdTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        label = {
            Text("Name",  color = MaterialTheme.colorScheme.scrim,)

        },
        placeholder = {
            Text(text = "Enter your name")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Red,
            backgroundColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth(1f).padding(horizontal = 17.dp)  ,
    )
}

@Composable
fun LastNamerdTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        label = {
            Text("Last name",  color = MaterialTheme.colorScheme.scrim,)

        },
        placeholder = {
            Text(text = "Enter your Last Name")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Red,
            backgroundColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth(1f).padding(horizontal = 17.dp)  ,
    )
}


@Composable
fun SexeTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =12.dp, bottomStart =12.dp),

        label = {
            Text("Last name",  color = MaterialTheme.colorScheme.scrim,)

        },
        placeholder = {
            Text(text = "Enter your Last Name")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Red,
            backgroundColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth(1f).padding(horizontal = 17.dp)  ,
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewPasswordTextFields() {
    Name()
    Contents()

}