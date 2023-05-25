import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun PaymentScreen() {
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf(0.0) }


    val onPayClicked: (String, Double) -> Unit = { number, price ->
        phoneNumber = number
        amount = price
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Numéro de téléphone") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = amount.toString(),
            onValueChange = { amount = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Montant") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = { onPayClicked(phoneNumber, amount) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Payer")
        }
    }
}