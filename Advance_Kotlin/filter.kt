fun main () {
    val standardMenu = mutableSetOf("Espresso", "Latte", "Americano", "Latte")
    println(standardMenu)
    
    val latteFilter = standardMenu.filter {it == "Latte"}
    
    println(latteFilter)
}


Output :

[Espresso, Latte, Americano]
[Latte]
