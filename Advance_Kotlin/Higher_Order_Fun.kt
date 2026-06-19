fun main () {
    val price = 10.0
    val calculateTax: (Double) -> Double = { price -> 
    price*0.08 
    }
    
    val printRecipt: (String, Double) -> Unit = {customer, total ->
    println("Reciept for $customer: $$total")
    }
    
    val taxAmount = calculateTax(price)
    printRecipt("Ayush",price+taxAmount)
}

Output :

Reciept for Ayush: $10.8
