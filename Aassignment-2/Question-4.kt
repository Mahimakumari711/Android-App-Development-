open class Employee(val baseSalary: Int)

class Manager : Employee(80000)

fun main() {
    val manager = Manager()
    println("Manager Base Salary: ${manager.baseSalary}")
}


Output :

Manager Base Salary: 80000
