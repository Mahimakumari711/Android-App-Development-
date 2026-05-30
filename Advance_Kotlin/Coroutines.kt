import kotlinx.coroutines.*

fun main () = runBlocking {
    launch {
        delay(5000L)
        println("World")
    }
    
    launch {
        delay(4000L)
        println("Ayush")
    }
    
    println("Hello,")
}


Output :

Hello,
Ayush
World

// Note : 1s -> 1000L miliseconds
