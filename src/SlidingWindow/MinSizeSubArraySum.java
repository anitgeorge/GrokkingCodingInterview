/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum
 * is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 * author @anitgeorge
 */

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    if(arr == null || arr.length == 0)
      return -1;
    int sum = 0, min = Integer.MAX_VALUE, start = 0, end = 0;
    while(end < arr.length){

        if(arr[end] >= S)
          return 1;
        sum += arr[end];
        while(sum >= S){
          min = Math.min(min, end - start + 1);
          sum -= arr[start++];
        }
        end++;
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
