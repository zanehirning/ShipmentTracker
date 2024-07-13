package updates

import Shipment

class Canceled : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        shipment.status = "canceled"
    }
}