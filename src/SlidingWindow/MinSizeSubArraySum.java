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
