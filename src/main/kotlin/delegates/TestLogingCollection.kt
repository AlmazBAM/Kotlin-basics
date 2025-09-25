package delegates

fun main() {
    val loggingMutableList = LoggingMutableList<Int>(mutableListOf())

    loggingMutableList.add(30)
    loggingMutableList.add(142)
    loggingMutableList.add(0,42)

    println(loggingMutableList.size)
}