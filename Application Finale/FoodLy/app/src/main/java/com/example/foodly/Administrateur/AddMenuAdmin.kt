package com.example.foodly.Administrateur

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.LightGreen2
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddMenuAdmin(navController: NavController){
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var Confirmed = false
    var Image by remember { mutableStateOf<Uri?>(null) }
    var name by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var restaurant_name by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }
    var quantiteCom = 1
    val gradientColor = listOf(LightGreen, Color.Black)
    val cornerRadius = 16.dp

    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    var showDialogEmail by remember { mutableStateOf(false) }
    var showDialogPhoneNumber by remember { mutableStateOf(false) }
    var showDialogPassWord by remember { mutableStateOf(false) }



    val db = Firebase.firestore
    val start_date = Date().toString()
    val customerCollectionRef = db.collection("Menu")

    fun SaveMenu() {
        // Créer un nouveau document avec le username renseigné
        val newMenu = hashMapOf(
            "Confirmed" to Confirmed,
            "Image" to Image,
            "date" to start_date,
            "name" to name,
            "price" to price.toInt(),
            "quantity" to quantity.toInt(),
            "quantiteCom" to quantiteCom,
            "restaurant_name" to restaurant_name
        )

        // Ajouter le nouveau document à la collection "customer"
        customerCollectionRef.add(newMenu)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Administrateur") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.DashBoard.route) }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = {

            val imageUrls = listOf(
                "https://i.pinimg.com/564x/36/94/5d/36945d86a7fcdac69ca96286de20ac71.jpg",
                "https://i.pinimg.com/736x/63/97/75/6397752e9d13e39a65a1457f188a952a.jpg",
                "https://i.pinimg.com/564x/a2/9c/a5/a29ca515e9f19e6fd3d4b281c87ad373.jpg"
            )

            val selectedImageUrl = remember { mutableStateOf(imageUrls[0]) }

            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {

                item{
                    Spacer(modifier = Modifier.height(25.dp))
                    val launcher =
                        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                            Image = uri
                        }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.LightGray, CircleShape)
                            .clickable {
                                launcher.launch("image/*")
                            }
                    ) {

                        Image?.let {
                            if (Build.VERSION.SDK_INT < 28) {
                                bitmap.value = MediaStore.Images
                                    .Media.getBitmap(context.contentResolver, it)
                            } else {
                                val source = ImageDecoder.createSource(context.contentResolver, it)
                                bitmap.value = ImageDecoder.decodeBitmap(source)
                            }
                            bitmap.value?.let { btm ->
                                Image(
                                    bitmap = btm.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(128.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(25.dp))

                    androidx.compose.material.OutlinedTextField(
                        value = restaurant_name,
                        onValueChange = { restaurant_name = it },
                        shape = RoundedCornerShape(20.dp),
                        label = {
                            Text(
                                "Name Restaurant",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        placeholder = { Text(text = "Name Restaurant") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text
                        ),
                        leadingIcon = {
                            androidx.compose.material.Icon(
                                Icons.Filled.RestaurantMenu,
                                contentDescription = "Restaurant"
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightGreen,
                            unfocusedBorderColor = LightGreen
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )

                    )
                }

                item{
                    Spacer(modifier = Modifier.height(25.dp))

                    androidx.compose.material.OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        shape = RoundedCornerShape(20.dp),
                        label = {
                            Text(
                                "Name",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        placeholder = { Text(text = "Name") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text
                        ),
                        leadingIcon = {
                            androidx.compose.material.Icon(
                                Icons.Filled.Restaurant,
                                contentDescription = "RestaurantMenu"
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightGreen,
                            unfocusedBorderColor = LightGreen
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )

                    )
                }

                item{
                    Spacer(modifier = Modifier.height(25.dp))

                    Column {
                        // Liste déroulante
                        DropdownMenu(
                            expanded = false,
                            onDismissRequest = { },
                            modifier = Modifier
                                .width(200.dp)
                                .background(LightGreen)
                        ) {
                            imageUrls.forEach { url ->
                                androidx.compose.material.DropdownMenuItem(onClick = {
                                    // Lorsque l'utilisateur clique sur un élément, mettre à jour l'URL sélectionnée
                                    selectedImageUrl.value = url
                                }) {
                                    Text(url)
                                }
                            }
                        }
                    }
                }

                item{
                    Spacer(modifier = Modifier.height(25.dp))

                    androidx.compose.material.OutlinedTextField(
                        value = price,
                        onValueChange = { if (it.matches(Regex("[0-9]*"))) {
                            price = it
                        } },
                        shape = RoundedCornerShape(20.dp),
                        label = {
                            Text(
                                "Price",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        placeholder = { Text(text = "Price") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text
                        ),
                        leadingIcon = {
                            androidx.compose.material.Icon(
                                Icons.Filled.Numbers,
                                contentDescription = "Price"
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightGreen,
                            unfocusedBorderColor = LightGreen
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )

                    )
                }

                item{
                    Spacer(modifier = Modifier.height(25.dp))

                    androidx.compose.material.OutlinedTextField(
                        value = quantity,
                        onValueChange = { if (it.matches(Regex("[0-9]*"))) {
                            quantity = it
                        } },
                        shape = RoundedCornerShape(20.dp),
                        label = {
                            Text(
                                "Quantity",
                                color = MaterialTheme.colorScheme.scrim,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        placeholder = { Text(text = "Quantity") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text
                        ),
                        leadingIcon = {
                            androidx.compose.material.Icon(
                                Icons.Filled.ConfirmationNumber,
                                contentDescription = "Quantity"
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightGreen,
                            unfocusedBorderColor = LightGreen
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )

                    )
                }

                item{
                    Spacer(modifier = Modifier.height(25.dp))

                    var showDialog by remember { mutableStateOf(false) }

                    Button(
                        onClick = {
                            try {
                                SaveMenu()
                                showDialog = true
                            }catch(e: Exception) {
                                println("Erreur : $e.message")
                            }
                        },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(LightGreen)
                    ) {
                        Text(text = "Add Menu", color = Color.White)
                    }


                    if (showDialog) {
                        androidx.compose.material.AlertDialog(
                            onDismissRequest = { showDialog = false },
                            title = { Text(text = "Confirmation") },
                            text = { Text(text = "Menu Ajouté") },
                            confirmButton = {
                                androidx.compose.material.Button(
                                    onClick = { if (showDialog) navController.navigate(Screen.DashBoard.route) },
                                    colors = androidx.compose.material.ButtonDefaults.buttonColors(
                                        LightGreen
                                    )
                                ) {
                                    Text("OK")
                                }
                            },
                            modifier = Modifier.padding(16.dp),
                            shape = RoundedCornerShape(30.dp),
                        )
                    }
                }
            }
        }
    )
}