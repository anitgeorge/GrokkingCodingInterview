import java.util.*;

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    if(arr == null || arr.length == 0
       || k <= 0 || k > arr.length
    )
    return -1;

    int sum = 0, max = Integer.MIN_VALUE, start = 0, end = 0;
    while(end < arr.length){

        sum += arr[end];
        if(end++ >= k - 1){
          max = Math.max(sum, max);
          sum -= arr[start++];
        }
    }
    return max == Integer.MIN_VALUE ? -1 : max;
  }
}
