/**
 * Given an array of numbers and a number ‘K’, we need to remove ‘K’
 * numbers from the array such that we are left with maximum distinct
 * numbers.
 *
 * Input: [7, 3, 5, 8, 5, 3, 3], and K=2
 * Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers
 * [7, 3, 8], we have to skip 5 because it is not distinct and occurred twice.
 * Another solution could be to remove one instance of '5' and '3' each to be left with three
 * distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
 *
 * @author anitgeorge
 */

import java.util.*;

public class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        int count = 0;
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                ++count;
            else
                minHeap.offer(entry);
        }

        while( k > 0 && !minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            k -= entry.getValue() - 1;
            if(k >= 0){
                ++count;
            }
        }
        return k > 0 ? count - k: count;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}