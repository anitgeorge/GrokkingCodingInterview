/**
 *
 * Given an array of numbers sorted in ascending order,
 * find the element in the array that has the minimum
 * difference with the given ‘key’.
 *
 * @author anitgeorge
 */

public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {

        if(arr == null || arr.length == 0)
            return -1;
        if(key < arr[0])
            return arr[0];
        if(key > arr[arr.length - 1])
            return arr[arr.length - 1];
        int start = 0, end = arr.length - 1, mid = 0;
        while(start <= end){

            mid = start + (end - start) / 2;
            if(arr[mid] == key)
                return arr[mid];
            else if(arr[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return Math.abs(arr[start] - key) > Math.abs(arr[end] - key) ? arr[end] : arr[start];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
