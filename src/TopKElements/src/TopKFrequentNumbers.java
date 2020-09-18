/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * @author anitgeorge
 */

import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        if(nums == null || nums.length < k || k <= 0 )
            return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        maxHeap.addAll(map.entrySet());
        for(int i = 0; i < k ; i++)
            result.add(maxHeap.poll().getKey());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
