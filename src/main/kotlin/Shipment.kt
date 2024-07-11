class Shipment(
    val id: String,
    val timeStampOfUpdate: String,
) : ShipmentSubject {

    override fun subscribe(observer: ShipmentObserver) {
        TODO("Not yet implemented")
    }

    override fun unsubscribe(observer: ShipmentObserver) {
        TODO("Not yet implemented")
    }

    override fun notifyObserver() {
        TODO("Not yet implemented")
    }
}