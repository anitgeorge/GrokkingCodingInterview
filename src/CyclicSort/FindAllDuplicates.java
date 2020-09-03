/**
 *
 * We are given an unsorted array containing ‘n’ numbers taken from
 * the range 1 to ‘n’. The array has some duplicates, find all the
 * duplicate numbers without using any extra space.
 *
 * @author anitgeorge
 */

import java.util.*;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return duplicateNumbers;
        int i = 0;
        while( i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        for(i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}
