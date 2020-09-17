/**
 * Given an unsorted array of numbers, find Kth smallest number in it.
 *
 * Please note that it is the Kth smallest number in the sorted order,
 * not the Kth distinct element.
 *
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
 *
 * @author anitgeorge
 */

import java.util.*;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        if(nums == null || nums.length == 0
                || k > nums.length || k <= 0
        )
            return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        int i = 0;
        for(; i < k; i++)
            maxHeap.offer(nums[i]);
        for(; i < nums.length; i++)
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
