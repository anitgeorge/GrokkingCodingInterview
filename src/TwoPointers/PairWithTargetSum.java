/**
 *
 * Given an array of sorted numbers and a target sum, find a pair
 * in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers
 * (i.e. the pair) such that they add up to the given target.
 *
 * @author anitgeorge
 */

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        if(arr == null || arr.length < 2)
            return new int[] { -1, -1 };
        int start = 0, end = arr.length - 1;
        while(start <= end){

            if(arr[start] + arr[end] == targetSum)
                return new int[]{start, end};
            else if(arr[start] + arr[end] > targetSum)
                end--;
            else
                start++;
        }

        return new int[]{-1, -1};
    }
}