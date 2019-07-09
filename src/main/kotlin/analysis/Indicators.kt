package org.photoni.math.analysis

/**
 * Contains all the indicators functions
 */
class Indicators {
    companion object Static {
        /* Moving Averages*/
        /**
         * Simple Mooving average
         * @param n time period
         * @param arr time series
         */
        fun sma(n: Int, arr: DoubleArray): DoubleArray {
            var sma = DoubleArray(arr.size) { Double.NEGATIVE_INFINITY }
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

        /**
         * Exponential Mooving average
         * @param n time period
         * @param arr time series
         */
        fun ema(n: Int, arr: DoubleArray): DoubleArray {
            val smmothingConstant = 2 / (5 + 1)
            /* STEP:1 computing EMA initial value. i.e SMA of fir n values */
            var tmp = DoubleArray(n)
            for (i in 0 until n - 1) {
                tmp[i] = arr[i]
            }
            val emaInit = tmp.average()
            /* STEP:2 smoothing constant*/
            val smooth = 2.0 / (n + 1)
            /* STEP:3 computing EMA */
            /* EMA = (closing price - previous day's EMA) × smoothing constant as a decimal + previous day's EMA */
            var emas = DoubleArray(arr.size)
            emas[n - 1] = emaInit
            for (i in n until arr.size) {
                var ema = (arr[i] - emas[i - 1]) * smooth + emas[i - 1]
                emas[i] = ema
            }
            return emas
        }
    }
}