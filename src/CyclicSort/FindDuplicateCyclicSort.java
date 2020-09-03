/**
 *
 * <p>
 *     https://www.educative.io/courses/grokking-the-coding-interview/3wEkKy6Pr9A
 * </p>
 * We are given an unsorted array containing ‘n+1’ numbers taken
 * from the range 1 to ‘n’. The array has only one duplicate but
 * it can be repeated multiple times. Find that duplicate number
 * without using any extra space. You are, however, allowed to
 * modify the input array.
 *
 * @author anitgeorge
 */

class FindDuplicateCyclicSort {

    public static int findNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int i = 0;
        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        for(i = 0; i < nums.length; i++)
            if( nums[i] != i + 1)
                return nums[i];
        return -1;
    }

    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}
