package org.photoni.math.analysis

import org.junit.Test

class IndicatorsTest {


    @Test
    fun sma() {
        val n=5
        val arr = doubleArrayOf(11.0,12.0,13.0,14.0,15.0,16.0,17.0)
        var sma = Indicators.sma(n, arr)
        println("result ${sma.contentToString()}")
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