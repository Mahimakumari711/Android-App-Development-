fun main() {
    val n = 50

    println("Prime numbers from 1 to $n are:")

    for (i in 2..n) {
        var isPrime = true

        for (j in 2 until i) {
            if (i % j == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) {
            print("$i ")
        }
    }
}


Output :

Prime numbers from 1 to 50 are:
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
