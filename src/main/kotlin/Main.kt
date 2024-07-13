import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ui.ShipmentItem
import viewmodels.TrackerViewModel

@Composable
@Preview
fun App() {
    val viewModel = TrackerViewModel()
    val state = viewModel.uiState
    val coroutineScope = rememberCoroutineScope()

    MaterialTheme {
        coroutineScope.launch {
            TrackingSimulator.runSimulation()
            delay(1000)
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = state.shipmentTextFieldText,
                    onValueChange = { state.shipmentTextFieldText = it },
                    placeholder = { Text("Enter Shipment Id") }
                )
                Button(onClick = {
                    viewModel.startTrackingShipment(TrackingSimulator.findShipment(state.shipmentTextFieldText.text))
                }) {
                    Text("Search")
                }
            }
            state.trackedShipments.forEach {
                ShipmentItem(
                    it,
                    onShipmentClose = {
                        viewModel.stopTrackingShipment(it)
                    }
                )
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
