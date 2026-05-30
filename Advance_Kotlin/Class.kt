class Coffee (
val name: String,
val price: Double,
val description: String
)
{
    fun tellPrice(): String 
    {
        return "$name costs: $$price"
    }
    fun describeCoffee() 
    {
        println("$name : $description")
    }
}

fun main() {
    var coffeelatte = Coffee("Latte", 9.0, "Espresso with milk")
    coffeelatte.describeCoffee()
    println(coffeelatte.tellPrice())
    
    var coffeeIced = Coffee("Iced Coffee", 10.00, "Coffee with ice ")
    println(coffeeIced.tellPrice())
}


Output :

Latte : Espresso with milk
Latte costs: $9.0
Iced Coffee costs: $10.0
