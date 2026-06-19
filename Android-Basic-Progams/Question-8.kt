fun main() {
    var number = 12345
    var count = 0

    while (number != 0) {
        number /= 10
        count++
    }

    println("Number of digits = $count")
}

Output :

Number of digits = 5
