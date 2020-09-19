/**
 *
 * Given a sorted number array and two integers ‘K’ and ‘X’,
 * find ‘K’ closest numbers to ‘X’ in the array. Return the
 * numbers in the sorted order. ‘X’ is not necessarily present
 * in the array.
 *
 * Input: [5, 6, 7, 8, 9], K = 3, X = 7
 * Output: [6, 7, 8]
 *
 * @author anitgeorge
 */

import java.util.*;

public class KClosestElements {

    public static List<Integer> findClosestElements(int[] nums, int K, Integer X) {

        if(nums == null || nums.length < K)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> diff(X, nums[b]) - diff(X, nums[a])
        );
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for(; i < K; i++)
            maxHeap.offer(i);
        for(; i < nums.length; i++){
            if(diff(nums[i], X) < diff(nums[maxHeap.peek()], X)){
                maxHeap.poll();
                maxHeap.offer(i);
            }
        }
        while(!maxHeap.isEmpty())
            result.add(nums[maxHeap.poll()]);
        return result;
    }
    private static int diff(int a, int b){
        return Math.abs(a - b);
    }
    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
