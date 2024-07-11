package updates

import Shipment

class Canceled : Update {
    override fun apply(shipment: Shipment) {
        println("Canceled")
    }
}