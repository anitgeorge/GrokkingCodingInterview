/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more
 * than ‘k’ 0s with 1s, find the length of the longest contiguous
 * subarray having all 1s.
 *
 * @author anitgeorge
 */

import java.util.*;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
       if(arr == null || arr.length == 0)
           return 0;
       int start    = 0;
       int end      = 0;
       int oneCount = 0;
       int maxLen   = Integer.MIN_VALUE;

       for(; end < arr.length; end++){

           if(arr[end] == 1)
               oneCount++;
           if(end - start + 1 - oneCount > k)
               if(arr[start++] == 1)
                   oneCount--;
           maxLen = Math.max(maxLen, end - start + 1);
       }

       return maxLen;
    }
}