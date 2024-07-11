package updates

import Shipment

class NoteAdded : Update {
    override fun apply(shipment: Shipment) {
        println("Note added")
    }
}