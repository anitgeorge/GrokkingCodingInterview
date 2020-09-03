/**
 * We are given an unsorted array containing ‘n’ numbers taken 
 * from the range 1 to ‘n’. The array originally contained all
 * the numbers from 1 to ‘n’, but due to a data error, one of 
 * the numbers got duplicated which also resulted in one number
 * going missing. Find both these numbers.
 *
 * @author anitgeorge
 */

class FindCorruptPair {

    public static int[] findNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int  i = 0;
        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        for(i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                return new int[]{nums[i], i + 1};

        return new int[]{-1, -1};
    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }
}
