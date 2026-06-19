data class User(
    val id: Int,
    val username: String,
    val isActive: Boolean
)

fun main() {
    val user = User(1, "john_doe", true)

    println(user)
}


Output :

User(id=1, username=john_doe, isActive=true)
