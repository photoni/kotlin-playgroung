package org.photoni.math.analysis

/**
 * Contains all the indicators functions
 */
object Aroon {
    const val n25 = 25


    /* --------------- MOVING AVERAGES ---------------------*/
    /**
     * Simple Mooving average
     * @param n time period
     * @param arr time series
     */
    fun up(arr: DoubleArray): DoubleArray {
        var up = DoubleArray(arr.size) { Double.NEGATIVE_INFINITY }

        return up
    }

    fun daysFromHigh(index:Int,days:Int,arr: DoubleArray): Int {
        var indexOfHigh:Int=0
        var high:Double=0.0
        for (i in 0..days){
            val currentIndex = index + i

            if(arr[currentIndex] > high){
                high=arr[currentIndex]
                indexOfHigh=currentIndex
            }
        }
        return indexOfHigh-index


    }



}