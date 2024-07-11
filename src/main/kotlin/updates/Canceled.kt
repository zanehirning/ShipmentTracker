package updates

class Canceled : Update {
    override fun apply() {
        println("Canceled")
    }
}