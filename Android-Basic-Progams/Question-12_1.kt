fun main() {
    var a = 10
    var b = 20

    val temp = a
    a = b
    b = temp
    
    println("a = $a")
    println("b = $b")
}


Output :

a = 20
b = 10
