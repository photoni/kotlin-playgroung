import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayTest {


    @Test
    fun intArrayAssignmentPerformance() {
        val arr = IntArray(10000000)
        val start = System.nanoTime()
        for(i in arr.indices){
            arr[i]=i*i
        }
        val end = System.nanoTime()
        println("nano ${end-start}")

    }

    @Test
    fun doubleArrayAssignmentPerformance() {
        val arr = DoubleArray(10000000)
        val start = System.nanoTime()
        for(i in arr.indices){
            arr[i]=i*0.1
        }
        val end = System.nanoTime()
        println("nano ${end-start}")

    }
}