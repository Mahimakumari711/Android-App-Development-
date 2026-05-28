fun main() {
    var number = 121
    var originalNumber = number
    var reverse = 0

    while (number != 0) {
        val digit = number % 10
        reverse = reverse * 10 + digit
        number /= 10
    }

    if (originalNumber == reverse) {
        println("$originalNumber is a Palindrome")
    } else {
        println("$originalNumber is not a Palindrome")
    }
}

Output :

121 is a Palindrome
