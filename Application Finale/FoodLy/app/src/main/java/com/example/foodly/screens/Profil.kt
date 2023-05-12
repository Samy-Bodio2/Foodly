package com.example.foodly.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.R
import com.example.foodly.viewModels.ProfilViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.observe
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun ProfileScreen(profilViewModel: ProfilViewModel) {
    // Observateur pour les modifications des données de l'utilisateur
    val user by profilViewModel.userLiveData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        //Photo de profil
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp)
            )
        }

        // Informations personnelles
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Nom: ${user.username}",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Adresse Email: ${user.email}",
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Téléphone: ${user.phone}",
                    style = MaterialTheme.typography.body1
                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "Adresse de livraison: ${user.deliveryAddress}",
//                    style = MaterialTheme.typography.body1
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "Préférences alimentaires: ${user.foodPreferences}",
//                    style = MaterialTheme.typography.body1
//                )
            }
        }






//        // Historique des commandes
//        Card(
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .fillMaxWidth(),
//            elevation = 8.dp
//        ) {
//            Column(
//                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
//            ) {
//
//                Text(
//                    text = "Historique des commandes",
//                    style = MaterialTheme.typography.h6
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//
//                user.orderHistory.forEach { order ->
//                    Text(
//                        text = "${order.date} - Total : ${order.totalAmount}",
//                        style = MaterialTheme.typography.body1,
//                        modifier = Modifier.padding(bottom = 8.dp)
//                    )
//
//                    order.items.forEach { item ->
//                        Text(
//                            text = "    • ${item.name} (${item.quantity} X ${item.price})",
//                            style = MaterialTheme.typography.body2
//                        )
//                    }
//                }
            }
        }

//        // Points de fidélité
//        Card(
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .fillMaxWidth(),
//            elevation = 8.dp
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Points de fidélité",
//                    style = MaterialTheme.typography.h6
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = "${user.pointsLoyalty} Points disponibles",
//                    style = MaterialTheme.typography.body2
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
////                Button(onClick = { /* action */ }) {
////                Text("Obtenir une remise")
////            }
//            }
//        }
//    }
//}

@Preview
@Composable
fun PreviewProfil(){

}