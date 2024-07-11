package viewhelpers

import ShipmentObserver

class TrackerViewHelper() : ShipmentObserver {

    override fun notify(shipmentId: String) {
        println("Shipment $shipmentId has been updated.")

        //TODO: handle the update process
        // I will probably want to have this just update the ui, and not handle the actual updating
        // My updates will handle changing shipment in TrackingSimulator, when values are updated, this will be called

    }

}