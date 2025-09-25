package delegates

import kotlin.io.encoding.Base64
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val user = User()
    user.password = "123456"
    println(user.password)

    user.creditCardNumber = "4270 0000 0000 0000"
    println(user.creditCardNumber)

    user.observable = 10
    user.observable = 101
}

class User {

    var observable by myObservable(0) { old, new ->
        println("old $old, new $new")
    }

    var password: String by encrypted()

    var creditCardNumber: String by encrypted()
}

fun <T> myObservable(initialValue: T, onChange: (T, T) -> Unit) = MyObservable(initialValue, onChange)

class MyObservable<T>(initial: T, private val onChange: (old: T, new: T) -> Unit) : ReadWriteProperty<Any, T> {

    private var currentValue = initial

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return currentValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        onChange(currentValue, value)
        currentValue = value
    }
}

private fun encrypted() = EncryptedProperty()

class EncryptedProperty : ReadWriteProperty<Any, String> {
    private var encryptedProperty = ""

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        val decode = String(Base64.decode(encryptedProperty)).also {
            println("Encoded $encryptedProperty")
            println("Decoded $it")
        }
        return decode
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("New value $value")
        val encoded = Base64.encode(value.toByteArray())
        println("Encoded $encoded")
        encryptedProperty = encoded
    }
}