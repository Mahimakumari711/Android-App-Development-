fun main() {
    val result = largest(10, 25, 15)
    println("Largest number is $result")
}

fun largest(a: Int, b: Int, c: Int): Int {
    return if (a >= b && a >= c) {
        a
    } else if (b >= a && b >= c) {
        b
    } else {
        c
    }
}


Output :

Largest number is 25
