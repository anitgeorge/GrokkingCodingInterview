/**
 *
 * <p>
 *     https://leetcode.com/problems/missing-number/
 * </p>
 * We are given an array containing ‘n’ distinct numbers taken from the
 * range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total
 * ‘n+1’ numbers, find the missing number.
 *
 * @author anitgeorge
 */

class MissingNumberCyclicSort {
    public int missingNumber(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        while(i < nums.length){

            int j = nums[i];
            if(nums[i] < nums.length && nums[j] != nums[i]){
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j]  = temp;
            } else{

                i++;
            }
        }

        for(i = 0; i < nums.length; i++)
            if(nums[i] != i)
                return i;
        return nums.length;
    }
}