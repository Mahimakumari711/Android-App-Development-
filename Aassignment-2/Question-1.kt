class BankAccount {
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited: $amount")
        } else {
            println("Invalid deposit amount")
        }
    }

    fun displayBalance() {
        println("Current Balance: $balance")
    }
}

fun main() {
    val account = BankAccount()

    account.deposit(1000.0)
    account.deposit(500.0)

    account.displayBalance()
}


Output :

Deposited: 1000.0
Deposited: 500.0
Current Balance: 1500.0
