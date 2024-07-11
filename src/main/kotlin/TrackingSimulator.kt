import updates.*

object TrackingSimulator {
    private val updateOperations: Map<String, Update> = mapOf(
        "created" to Created(),
        "canceled" to Canceled(),
        "delayed" to Delayed(),
        "delivered" to Delivered(),
        "location" to Location(),
        "lost" to Lost(),
        "noteAdded" to NoteAdded(),
        "shipped" to Shipped()
    )
    private var shipments: List<Shipment> = listOf()

    fun runSimulation() {
        /**
         * Read from file
         */

    }

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    fun addShipment(shipment: Shipment) {
        shipments += shipment
    }

    fun update(shipmentId: String, operation: String) {
        val shipment = findShipment(shipmentId)
        if (shipment != null) {
            if (operation in updateOperations) {
                //TODO: Think about passing in shipmentId/shipment
                updateOperations[operation]?.apply(shipment)
            }
        }
    }
}