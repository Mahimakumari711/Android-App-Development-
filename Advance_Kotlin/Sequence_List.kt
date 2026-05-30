fun main () {
    val standardMenu = mutableListOf("Espresso", "Latte", "Americano")
    println(standardMenu[2])
    
    standardMenu[1] = "IcedCoffee"
    println(standardMenu)
}

Output :

Americano
[Espresso, IcedCoffee, Americano]
