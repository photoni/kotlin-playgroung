import org.junit.Assert.assertEquals
import org.junit.Test

class GenericTest {
    fun printMessage(message: String) {
        println(message)
    }

    fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
        println("[$prefix] $message")
    }

    fun sum(x: Int, y: Int): Int {                                          // 3
        return x + y
    }

    fun helloWorld(name: String = "World"): String {
        return "Hello, $name!"
    }

    @Test
    fun test() {
        assertEquals("Hello, Molly!", helloWorld("Molly"))

    }
}