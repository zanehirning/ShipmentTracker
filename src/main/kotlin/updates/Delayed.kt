package updates

import Shipment

class Delayed : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        shipment.status = "delayed"
        shipment.expectedDeliveryDateTimestamp = otherInfo.toLong()
    }
}