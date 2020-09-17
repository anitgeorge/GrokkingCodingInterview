/**
 *
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 *
 * @author anitgeorge
 */

import java.util.*;

class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        if(nums == null || nums.length == 0
                || k > nums.length || k <= 0
        )
            return new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        for(; i < k; i++)
            minHeap.offer(nums[i]);
        for(; i < nums.length; i++)
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
