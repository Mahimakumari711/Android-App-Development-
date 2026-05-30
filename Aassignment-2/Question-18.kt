import kotlinx.coroutines.*

suspend fun fetchWeather(): String {
    delay(1000)
    return "Sunny"
}

fun main() = runBlocking {
    val weather = fetchWeather()
    println(weather)
}


Output :

Sunny
