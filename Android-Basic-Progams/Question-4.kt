fun main() {
    var number = 123
    var reverse = 0

    while (number != 0) {
        val digit = number % 10
        reverse = reverse * 10 + digit
        number /= 10
    }

    println("Reversed number = $reverse")
}


Output :

Reversed number = 321
