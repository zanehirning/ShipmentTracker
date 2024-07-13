package updates

import Shipment

class Lost : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        println("Lost")
    }
}