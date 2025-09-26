package data

fun main() {
    val dictionary = listOf(
        MyPair("Hello", "Bonjour"),
        MyPair("Thank you", "Merci")
    )
    val dictionary2 = listOf(
        "Hello" to "Bonjour",
        "Thank you" myTo "Merci"
    )

    for ((first, second) in dictionary) {
        println("$first - $second")
    }
}

infix fun <T, R> T.myTo(value: R): Pair<T, R> {
    return Pair(this, value)
}

data class MyPair<F, S>(val first: F, val second: S)