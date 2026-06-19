data class User(
    val id: Int,
    val username: String,
    val isActive: Boolean
)

fun main() {
    val user = User(1, "john_doe", true)
    val inactiveUser = user.copy(isActive = false)

    println(user)
    println(inactiveUser)
}


Output :

User(id=1, username=john_doe, isActive=true)
User(id=1, username=john_doe, isActive=false)
