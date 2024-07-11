package updates

import Shipment

class Delayed : Update {
    override fun apply(shipment: Shipment) {
        println("Delayed update")
    }
}