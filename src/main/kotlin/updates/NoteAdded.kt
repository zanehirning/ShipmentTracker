package updates

import Shipment

class NoteAdded : Update {
    override fun apply(shipment: Shipment, otherInfo: String) {
        println("Note added")
    }
}