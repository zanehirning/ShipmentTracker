package viewmodels

import Shipment
import ShipmentObserver
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

class TrackerViewModelState {
    var shipmentTextFieldText by mutableStateOf(TextFieldValue(""))
    val _trackedShipments = mutableStateListOf<Shipment>()
    val trackedShipments: List<Shipment> get() = _trackedShipments
}

class TrackerViewModel() : ShipmentObserver {
    val uiState = TrackerViewModelState()

    override fun notify(shipment: Shipment) {
        // Update the shipment in the list
        uiState._trackedShipments.replaceAll { if (it.id == shipment.id) shipment else it }
    }

    fun startTrackingShipment(shipment: Shipment?) {
        if (shipment != null) {
            shipment.subscribe(this)
            uiState._trackedShipments.add(shipment)
        }
    }

    fun stopTrackingShipment(shipment: Shipment) {
        shipment.unsubscribe(this)
        uiState._trackedShipments.remove(shipment)
    }
}