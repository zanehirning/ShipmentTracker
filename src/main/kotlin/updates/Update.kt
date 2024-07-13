package updates

import Shipment

interface Update {
    fun apply(shipment: Shipment, otherInfo: String)
}