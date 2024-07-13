import updates.Update

class Shipment(
    val id: String,
) : ShipmentSubject {
    var status: String = "created"
        set(value) {
            field = value
            notifyObserver()
        }
    var location: String = ""
        set(value) {
            field = value
            notifyObserver()
        }
    var notes = mutableListOf<String>()
        set(value) {
            field = value
            notifyObserver()
        }
    var updateHistory = mutableListOf<ShippingUpdate>()
        set(value) {
            field = value
            notifyObserver()
        }
    var expectedDeliveryDateTimestamp: Long = 0
        set(value) {
            field = value
            notifyObserver()
        }
    private val subscribers = mutableListOf<ShipmentObserver>()

    fun addUpdate(update: Update, timeStampOfUpdate: String, otherInfo: String) {
        update.apply(this, otherInfo)
        updateHistory += ShippingUpdate(
            previousStatus = updateHistory.last().newStatus,
            newStatus = this.status,
            timestamp = timeStampOfUpdate.toLong()
        )
    }

    fun addNote(note: String) {
        notes += note
    }

    override fun subscribe(observer: ShipmentObserver) {
        subscribers.add(observer)
    }

    override fun unsubscribe(observer: ShipmentObserver) {
        subscribers.remove(observer)
    }

    override fun notifyObserver() {
        subscribers.forEach {
            it.notify(this.id)
        }
    }
}