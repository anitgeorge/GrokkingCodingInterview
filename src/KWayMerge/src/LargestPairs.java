/**
 *
 * Given two sorted arrays in descending order, find ‘K’
 * pairs with the largest sum where each pair consists
 * of numbers from both the arrays.
 *
 * Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
 * Output: [9, 3], [9, 6], [8, 6]
 *
 * @author anitgeorge
 */

import java.util.*;

class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0
        )
            return result;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) -(nums1[b[0]] + nums2[b[1]])
        );
        for(int i = 0; i < nums1.length; i++)
            for(int j = 0; j < nums2.length; j++){
                minHeap.offer(new int[]{i, j});
                if(minHeap.size() > k)
                    minHeap.poll();
            }

        while(!minHeap.isEmpty()){
            int[] arr = minHeap.poll();
            result.add(new int[]{nums1[arr[0]], nums2[arr[1]]});
        }

        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}