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

    /**
     * @param index the index of the array to start from
     * @param days the number of days to go backward
     * @param arr the array of values
     */
    fun indexOfHighLow(index:Int,days:Int,arr: DoubleArray,findLow: Boolean): Int {
        var indexOfHighLow:Int=0
        var highLow:Double=if(findLow) Double.POSITIVE_INFINITY else Double.NEGATIVE_INFINITY
        val start = Math.max(0,index - days + 1)
        val signum=if(findLow) -1 else 1
        for (i in start..index){

            if((arr[i] - highLow)*signum>0){
                highLow=arr[i]
                indexOfHighLow=i
            }
        }
        return indexOfHighLow
    }



}