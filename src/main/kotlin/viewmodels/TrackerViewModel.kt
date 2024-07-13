package viewmodels

import Shipment
import ShipmentObserver
import TrackingSimulator
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

class TrackerViewModelState {
    var shipmentTextFieldText by mutableStateOf(TextFieldValue(""))
    var trackedShipments = mutableStateListOf<Shipment>()
    var trackedShipmentIds = mutableStateListOf<String>()
}

class TrackerViewModel() : ShipmentObserver {
    val uiState = TrackerViewModelState()

    override fun notify(shipment: Shipment) {
        println("Shipment ${shipment.id} has been updated.")

        val updatedList = uiState.trackedShipments.toMutableList()
        val index = updatedList.indexOfFirst { it.id == shipment.id }
        if (index != -1) {
            updatedList[index] = shipment
            // Update the mutable state list to trigger recomposition
            uiState.trackedShipments.clear()
            uiState.trackedShipments.addAll(updatedList)
        }
    }

    fun startTrackingShipment(shipmentId: String) {
        uiState.trackedShipmentIds.add(shipmentId)
        val shipment = TrackingSimulator.findShipment(shipmentId)
        if (shipment != null) {
            shipment.subscribe(this)
            uiState.trackedShipments.add(shipment)
        }
    }

    fun stopTrackingShipment(shipment: Shipment) {
        shipment.unsubscribe(this)
        uiState.trackedShipments.remove(shipment)
    }
}