/**
 *
 * Given an array of numbers sorted in ascending order,
 * find the range of a given number ‘key’. The range of
 * the ‘key’ will be the first and last position of the
 * ‘key’ in the array.
 *
 * Write a function to return the range of the ‘key’.
 * If the ‘key’ is not present return [-1, -1].
 *
 * @author anitgeorge
 */

public class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        if(arr == null || arr.length == 0
                || key < arr[0] || key > arr[arr.length - 1]
        )
           return result;
        result[0] = search(arr, key, false);
        if(result[0] == -1)
            return result;
        result[1] = search(arr, key, true);
        return result;
    }

    private static int search(int[] nums, int key, boolean flag){

        int start = 0, end = nums.length - 1, mid  = 0, index = -1;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(nums[mid] > key)
                end = mid - 1;
            else if(nums[mid] < key)
                start = mid + 1;
            else{
                index = mid;
                if(flag)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
