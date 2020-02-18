package analysis

/**
 * ZigZag
 * Filters out movements smaller than a threshold
 *
 */
object ZigZag {
    private const val threshold = 0.06


    /**
     * Zig Zag
     * @param arr
     */
    fun zigZag(arr: DoubleArray) {
       var lastValue =arr[0]
       var lastIndex=0
       for ( i in 1 until arr.size){
           if(((arr[i]-lastValue)/lastValue)< threshold)
               arr[i]=Double.NEGATIVE_INFINITY
           else{

               val steps = (i - lastIndex) - 1
               val stepValue=(arr[i]-lastValue)/steps

               for ( j in 1 until steps){
                   arr[i-j]=arr[i]-stepValue
               }

               lastValue=arr[i]
               lastIndex=i
           }
       }
    }

}