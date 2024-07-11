class Shipment(
    val id: String,
    val timeStampOfUpdate: String,
) : ShipmentSubject {

    private val subscribers = mutableListOf<ShipmentObserver>()

    override fun subscribe(observer: ShipmentObserver) {
        TODO("Not yet implemented")
    }

    override fun unsubscribe(observer: ShipmentObserver) {
        TODO("Not yet implemented")
    }

    override fun notifyObserver() {
        subscribers.forEach {
            it.notify(this.id)
        }
    }
}