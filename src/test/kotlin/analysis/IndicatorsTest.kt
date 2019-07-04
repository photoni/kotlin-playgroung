package org.photoni.math.analysis

import org.junit.Test

class IndicatorsTest {


    @Test
    fun sma() {
        val n=5
        val arr = doubleArrayOf(11.0,12.0,13.0,14.0,15.0,16.0,17.0)
        var sma = sma(n, arr)
        println("result ${sma.contentToString()}")
    }

    private fun sma(n: Int, arr: DoubleArray): DoubleArray {
        var sma = DoubleArray(7) { Double.NEGATIVE_INFINITY }
        var tmp = DoubleArray(n)

        for (i in 0 until n - 1) {
            tmp[i] = arr[i]
        }
        for (i in n - 1 until arr.size) {
            tmp[i % n] = arr[i]
            sma[i] = tmp.average()
        }
        return sma
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