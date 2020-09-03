/**
 * We are given an array containing ‘n’ objects. Each object,
 * when created, was assigned a unique number from 1 to ‘n’
 * based on their creation sequence. This means that the object
 * with sequence number ‘3’ was created just before the object
 * with sequence number ‘4’.
 *
 * Write a function to sort the objects in-place on their creation sequence
 * number in O(n) and without any extra space. For simplicity,
 * let’s assume we are passed an integer array containing only the sequence
 * numbers, though each number is actually an object.
 * @author anitgeorge
 */

class CyclicSort {

    public static void sort(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int i = 0;
        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = temp;
    }
}
