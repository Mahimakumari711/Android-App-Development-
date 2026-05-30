class Coffee(
    val name: String,
    val description: String,
    initialPrice: Double
) {

    private var price: Double = initialPrice

    fun tellPrice(): String {
        return "$name costs: $$price"
    }

    fun describeCoffee() {
        println("$name : $description")
    }

    fun applyDiscount(discountPercentage: Double) {
        if (discountPercentage in 0.0..100.0) {
            price -= price * (discountPercentage / 100)
            println("Price after discount: $$price")
        }
    }
}

fun main() {

    val coffeeLatte = Coffee(
        "Latte",
        "Espresso with milk",
        9.0
    )

    coffeeLatte.describeCoffee()

    println(coffeeLatte.tellPrice())

    coffeeLatte.applyDiscount(10.0)

    println(coffeeLatte.tellPrice())
}


Output :

Latte : Espresso with milk
Latte costs: $9.0
Price after discount: $8.1
Latte costs: $8.1
