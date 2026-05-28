fun main() {
    var number = 1234
    var sum = 0

    while (number != 0) {
        val digit = number % 10
        sum += digit
        number /= 10
    }

    println("Sum of digits = $sum")
}

Output :

Sum of digits = 10
