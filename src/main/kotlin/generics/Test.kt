package generics


fun main() {
    val worker = Programmer("John")
    showName(worker)

    val workers: MutableList<Programmer> = ArrayList<Programmer>().apply {
        add(Programmer("Nick"))
        add(Programmer("Helen"))
    }

    showCount(workers)
}

private fun showCount(workers: List<Worker>) {
    println(workers.size)
}

private fun showName(worker: Worker) {
    println(worker.name)
}

open class Worker(val name: String)

class Programmer(name: String): Worker(name)

class Director(name: String): Worker(name)