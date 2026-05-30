class Thermostat {
    var temperature: Double = 20.0
        private set

    fun setTemperature(newTemperature: Double) {
        if (newTemperature >= 0) {
            temperature = newTemperature
        }
    }
}

fun main() {
    val thermostat = Thermostat()

    println("Initial Temperature: ${thermostat.temperature}")

    thermostat.setTemperature(25.0)

    println("Updated Temperature: ${thermostat.temperature}")
}


Output :

Initial Temperature: 20.0
Updated Temperature: 25.0
