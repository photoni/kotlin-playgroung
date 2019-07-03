import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayTest {


    @Test
    fun test() {
        val start = System.nanoTime()
        val arr = IntArray(10000000)
        for(i in arr.indices){
            arr[i]=i
        }
        val end = System.nanoTime()
        println("nano ${end-start}")

    }
}