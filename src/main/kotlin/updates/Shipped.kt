package updates

import Shipment

class Shipped : Update {
    override fun apply(shipment: Shipment) {
        println("Shipped")
    }
}