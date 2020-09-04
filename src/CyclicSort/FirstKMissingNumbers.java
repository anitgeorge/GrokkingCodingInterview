/**
 *
 * Given an unsorted array containing numbers and a number ‘k’,
 * find the first ‘k’ missing positive numbers in the array.
 *
 * @author anitgeorge
 */

import java.util.*;

class FirstKMissingNumbers {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0)
            return missingNumbers;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while(i < nums.length){
            set.add(nums[i]);
            if(nums[i] <= 0 || nums[i] >= nums.length){
                i++;
                continue;
            }
            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

        for(i = 0; i < nums.length && k > 0;i++){

            if(nums[i] != i + 1 && !set.contains(i + 1)){
                missingNumbers.add(i + 1);
                k--;
            }
        }
        while( k > 0){
            if(!set.contains(i)){
                missingNumbers.add(i++);
                k--;
            }
            else
                i++;
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}