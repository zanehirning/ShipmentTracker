package updates

import Shipment

class Shipped : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        println("Shipped")
    }
}