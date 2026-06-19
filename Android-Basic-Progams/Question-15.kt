fun main() {
    var a=0
    var b=1
    var n=10
    
    for ( i in 1..n){
        print("$a ")

        val next=a+b
        a=b
        b=next
    }
}


Output :

0 1 1 2 3 5 8 13 21 34 
