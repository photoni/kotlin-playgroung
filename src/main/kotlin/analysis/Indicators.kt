package org.photoni.math.analysis

/**
 * Contains all the indicators functions
 */
class Indicators {
    companion object Static {
        /* --------------- MOVING AVERAGES ---------------------*/
        /**
         * Simple Mooving average
         * @param n time period
         * @param arr time series
         */
        fun sma(n: Int, arr: DoubleArray): DoubleArray {
            var sma = DoubleArray(arr.size) { Double.NEGATIVE_INFINITY }
            var tmp = DoubleArray(n)
            /* STEP:1 computing SMA initial value. i.e SMA of first n values */
            for (i in 0 until n) {
                tmp[i] = arr[i]
            }
            sma[n - 1] = tmp.average()

            /* STEP:1 computing SMA */
            /* SMA = average of last n values */
            for (i in n until arr.size) {
                tmp[(i) % n] = arr[i]
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
            val smmothingConstant = 2 / (n + 1)
            /* STEP:1 computing EMA initial value. i.e SMA of fir n values */
            var tmp = DoubleArray(n)
            for (i in 0 until n) {
                tmp[i] = arr[i]
            }
            val emaInit = tmp.average()
            /* STEP:2 smoothing constant*/
            val smooth = 2.0 / (n + 1)
            /* STEP:3 computing EMA */
            /* EMA = (closing price - previous day's EMA) × smoothing constant as a decimal + previous day's EMA */
            var emas = DoubleArray(arr.size) { Double.NEGATIVE_INFINITY }
            emas[n - 1] = emaInit
            for (i in n until arr.size) {
                var ema = (arr[i] - emas[i - 1]) * smooth + emas[i - 1]
                emas[i] = ema
            }
            return emas
        }

        /**
         * Macd Line
         * @param n time period
         * @param arr time series
         */
        fun macdLine(arr: DoubleArray): DoubleArray {
            /* MACDLine = EMA(12)-EMA(26) */
            val n12 = 12
            val n26 = 26
            var ema12=ema(n12,arr)
            var ema26=ema(n26,arr)
            var macdLine = DoubleArray(arr.size){ Double.NEGATIVE_INFINITY }
            macdLine[n26-1]=ema12[n26-1]-ema26[n26-1]
            for(i in n26 until arr.size)
                macdLine[i]=ema12[i]-ema26[i]

            return macdLine
        }

    }
}