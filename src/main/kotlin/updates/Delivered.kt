package updates

import Shipment

class Delivered : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        shipment.status = "delivered"
    }
}