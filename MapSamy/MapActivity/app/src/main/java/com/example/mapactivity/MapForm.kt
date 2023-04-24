package com.example.mapactivity


import android.content.Intent
import android.graphics.drawable.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapactivity.ui.theme.orange
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.example.mapsam.MapsActivity
import android.content.*
import com.example.mapactivity.R
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun DesignMap(context: Context){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Spacer(modifier = Modifier.size(20.dp))

            Image(
                painter = painterResource(id = R.drawable.undraw_delivery_truck_vt6p),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                    .padding(top=60.dp)
            )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("Type here...") }
            OutlinedTextField(value = text, onValueChange ={
                newText -> text = newText
            },

                label = {
                    Text(text = "DeliverMan")
                } ,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            leadingIcon = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.Face,
                        contentDescription = "Email Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
            )
            Spacer(modifier = Modifier.size(30.dp))
//            var text by remember { mutableStateOf("Type here...") }
            OutlinedTextField(value = text, onValueChange ={
                    newText -> text = newText
            },

                label = {
                    Text(text = "PayementMode")
                } ,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                leadingIcon = {
                    IconButton(onClick = {}){
                        Icon(imageVector = Icons.Filled.List,
                            contentDescription = "Email Icon")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = {
                submitForm(context) }
            ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = orange
                ),
                        modifier = Modifier
                        .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 40.dp)  ) {
                Text(text = "Submit", color = Color.White)

            }
        }

    }
}

fun submitForm(context: Context) {
    val intent = Intent(context, MapsActivity::class.java)
    context.startActivity(intent)
}