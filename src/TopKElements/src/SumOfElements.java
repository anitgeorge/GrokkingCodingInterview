/**
 * Given an array, find the sum of all numbers between
 * the K1’th and K2’th smallest elements of that array.
 *
 * Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
 * Output: 23
 * Explanation: The 3rd smallest number is 5 and 6th smallest number 15.
 * The sum of numbers coming between 5 and 15 is 23 (11+12).
 *
 * @author anitgeorge
 */

import java.util.*;

public class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        if(nums == null || nums.length < k2 || k2 < k1)
            return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int i = 0;
        for(; i < k2 - 1; i++) // K2 is exclusive, maxHeap of peek() -> K2 - 1 th number
            maxHeap.offer(nums[i]);

        for(; i < nums.length; i++){
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        int count = k2 - k1 - 1; // k1 is exclusive.
        int sum = 0;
        while(count-- > 0 && !maxHeap.isEmpty())
            sum += maxHeap.poll();
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
