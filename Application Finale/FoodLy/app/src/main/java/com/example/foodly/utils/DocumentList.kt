

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

fun initializePayment(currency: String, amount: Int, description: String, email: String) {
    val client = OkHttpClient()
    val mediaType = "application/json".toMediaTypeOrNull()
    val body = RequestBody.create(
        mediaType,
        "{\"currency\": \"$currency\", \"amount\": $amount, \"description\": \"$description\", \"email\": \"$email\"}"
    )
    val request = Request.Builder()
        .url("https://api.notchpay.co/payments/initialize")
        .post(body)
        .addHeader("Authorization", "sb.TRLPK8LSmu22RmMD29q0XkJiJSpXQd3azt8usrchgdfeeYqNi3L1eoWmcfInWN2vswIZWjaHxE4s8va2dSCnsfBEcFHN1l4ZMI21aKGZh24xhZrKo50e3ce6soWcF")
        .addHeader("Content-Type", "application/json")
        .build()
    val response = client.newCall(request).execute()
}

@Composable
fun PaymentScreen(totalAmount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Total: $totalAmount XAF", fontSize = 24.sp)
        Button(onClick = { initializePayment("XAF", totalAmount, "Ma description", "email@email.com") }) {
            Text("Payer")
        }
    }
}