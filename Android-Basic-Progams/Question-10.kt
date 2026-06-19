fun main() {
    checkCharacter('a')
}

fun checkCharacter(ch: Char) {
    when (ch.lowercaseChar()) {
        'a', 'e', 'i', 'o', 'u' -> 
            println("$ch is a Vowel")

        else -> 
            println("$ch is a Consonant")
    }
}


Output :

x is a Consonant
