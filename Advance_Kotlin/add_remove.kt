fun main () {
    val standardMenu = mutableSetOf("Espresso", "Latte", "Americano", "Latte")
    println(standardMenu)
    
    standardMenu.remove("Latte")
    standardMenu.add("IcedCoffee")
    println(standardMenu)
}

// setOf -> unique elements
// MapOf -> dictionary -> key value mapping

// filter , any , groupby 


Output :

[Espresso, Latte, Americano]
[Espresso, Americano, IcedCoffee]
