package com.example.foodly.Pan

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Pan3(cartItems: List<CartItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mon panier") },
                navigationIcon = {
                    IconButton(onClick = { /* Retour en arrière */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        },
    content = {    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


      /*  Text(
            text = "",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp),
        )*/
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(cartItems) { cartItem ->
                CartItemRow(cartItem = cartItem)
            }
        }
        Divider(modifier = Modifier.fillMaxWidth())
        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        Text(
            text = "Total: ${totalPrice}€",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp),
        )
        Button(
            onClick = { /* Process checkout */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Commander")
        }
    }}
    )
    //

}

@Composable
fun CartItemRow(cartItem: CartItem) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(cartItem.imageUri),
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                text = cartItem.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Quantité: ${cartItem.quantity}",
                fontSize = 14.sp,
                color = Color.Gray,
            )
            Text(
                text = "${cartItem.price}€",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(top = 8.dp),
            )
        }
    }
}

data class CartItem(val id: Int, val name: String, val price: Double, val quantity: Int, val imageUri: String)


@Composable
@Preview
fun compile() {
  val panier = listOf(CartItem(1,"text", 12.0, 33,"https://img.sndimg.com/food/image/upload/f_auto,c_fill,q_80,ar_16:9,w_621,fl_progressive,h_349/v1/img/recipes/12/61/28/wzcS4sIJTveLDT21LXos_EMPRESS_CHICKEN_H_f.jpg"))

    Pan3(panier)

}