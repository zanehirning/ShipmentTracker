package updates

class Delayed : Update {
    override fun apply() {
        println("Delayed update")
    }
}