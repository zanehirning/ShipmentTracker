package updates

import Shipment
import TrackingSimulator

class Created : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        shipment.status = "created"
        TrackingSimulator.addShipment(shipment)
    }
}