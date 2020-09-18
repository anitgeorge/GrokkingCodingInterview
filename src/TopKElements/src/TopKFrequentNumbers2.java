/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * @author anitgeorge
 */

import java.util.*;

public class TopKFrequentNumbers2 {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        if(nums == null || nums.length < k || k <= 0 )
            return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        while(!minHeap.isEmpty())
            result.add(minHeap.poll().getKey());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers2.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers2.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
