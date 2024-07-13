package updates

import Shipment

class Location : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        shipment.location = otherInfo
    }
}