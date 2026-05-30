sealed class ScreenState 

object loading:ScreenState()

data class success(val data:String): ScreenState()

fun main () {
    val state: ScreenState = success("Data Loaded successfully ")
    println(state)
}

Output :

success(data=Data Loaded successfully )
