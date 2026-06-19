open class vehicle {
    open fun startEngine ()
    {
        println("Vehicle engine started")
    }
}

class motorcycle: vehicle () {
    override fun startEngine() {
        println ("Vrooooom")
    }
}

fun main () {
    var bike = motorcycle()
    bike.startEngine()
}


Output :

Vrooooom
