package properties

import kotlin.io.encoding.Base64
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun encrypted() = EncryptedProperty()

class EncryptedProperty internal constructor(): ReadWriteProperty<Any, String> {
    private var encryptedProperty = ""

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        val decode = encryptedProperty.decode().also {
            println("Encoded $encryptedProperty")
            println("Decoded $it")
        }
        return decode
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("New value $value")
        val encoded = value.encode()
        println("Encoded $encoded")
        encryptedProperty = encoded
    }

    fun String.encode() = Base64.encode(this.toByteArray())
    fun String.decode() = String(Base64.decode(this))
}