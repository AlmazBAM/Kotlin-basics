package delegates

import java.util.function.IntFunction

class LoggingMutableList<T> (private val mutableList: MutableList<T>) : MutableList<T> by mutableList {

    override fun add(element: T): Boolean {
        println("$element was added")
        return mutableList.add(element)
    }

    override fun add(index: Int, element: T) {
        println("$element was added at index $index")
        mutableList.add(index, element)
    }

    @Deprecated("This declaration overrides a deprecated member but is not marked as deprecated itself")
    override fun <T : Any?> toArray(generator: IntFunction<Array<out T?>?>): Array<out T?>? {
        return null
    }
}