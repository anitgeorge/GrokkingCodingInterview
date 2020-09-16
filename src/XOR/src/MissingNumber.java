/**
 *
 * Given an array of n−1 integers in the range from 1 to n,
 * find the one number that is missing from the array.
 *
 * Input: 1, 5, 2, 6, 4
 * Answer: 3
 *
 * @author anitgeorge
 */

public class MissingNumber {

    public static int findMissingNumber(int[] arr) {
       if(arr == null || arr.length == 0)
           return 0;
       int x1 = 1;
       int n = arr.length + 1;
       for(int i = 2; i <= n; i++)
           x1 ^= i;
       int x2 = arr[0];
       for(int i = 1; i < arr.length; i++)
           x2 ^= arr[i];
       return x1 ^ x2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }
}
