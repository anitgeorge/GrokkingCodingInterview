/**
 *
 * We are given an unsorted array containing numbers taken from the
 * range 1 to ‘n’. The array can have duplicates, which means some
 * numbers will be missing. Find all those missing numbers.
 *
 * @author anitgeorge
 */

import java.util.*;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return missingNumbers;
        int i = 0;
        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

        for(i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }
}
