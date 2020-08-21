/**
 * Given an array arr of unsorted numbers and a target sum, count
 * all triplets in it such that arr[i] + arr[j] + arr[k] < target
 * where i, j, and k are three different indices. Write a function
 * to return the count of such triplets.
 *
 * @author anitgeorge
 */

import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return -1;

        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++)
            count += search(arr, target - arr[i], i);
        return count;
    }

    private static int search(int[] arr, int target, int start){

        int count = 0;
        int left = start + 1, right = arr.length - 1;

        while(left < right){

            if(arr[left] + arr[right] < target){

                count += right - left;
                left++;
            } else{
                right--;
            }
        }
        return count;
    }
}