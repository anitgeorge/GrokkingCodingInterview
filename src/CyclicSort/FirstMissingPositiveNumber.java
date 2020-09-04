/**
 *
 * Given an unsorted array containing numbers,
 * find the smallest missing positive number in it.
 *
 * @author anitgeorge
 */

class FirstMissingPositiveNumber {

    public static int findNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int  i = 0;
        while(i < nums.length){

            if(nums[i] <= 0 || nums[i] >= nums.length){
                i++;
                continue;
            }
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j]   = temp;
            } else{
                i++;
            }
        }

        for(i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }
}
