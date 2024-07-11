package updates

import Shipment

class Location : Update {
    override fun apply(shipment: Shipment) {
        println("Location")
    }
}