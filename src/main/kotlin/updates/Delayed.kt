package updates

import Shipment

class Delayed : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        println("Delayed update")
    }
}