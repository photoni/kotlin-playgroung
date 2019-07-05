package org.photoni.math.analysis

/**
 * Contains all the indicators functions
 */
class Indicators {
    companion object Static {
        fun sma(n: Int, arr: DoubleArray): DoubleArray {
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
    }
}