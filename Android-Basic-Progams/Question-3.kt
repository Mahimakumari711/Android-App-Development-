fun main() {
    var res=sum(5)
    print("Sum of number = $res")
}

fun sum(n: Int): Int {
    var s=0
    for (i in 1..n)
    {
        s=s+i
    }
    return s
}


Output :

Sum of number = 15
