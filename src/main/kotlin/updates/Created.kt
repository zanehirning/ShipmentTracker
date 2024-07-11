package updates

import Shipment
import TrackingSimulator

class Created : Update {
    override fun apply(shipment: Shipment) {
        TrackingSimulator.addShipment(shipment)
    }
}