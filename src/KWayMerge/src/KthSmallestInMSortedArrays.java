/**
 *
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
 * Output: 4
 * Explanation: The 5th smallest number among all the arrays is 4,
 * this can be verified from the merged
 * list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 *
 * @author anitgeorge
 */

import java.util.*;

class KthSmallestInMSortedArrays {
    static class Pair{

        int listIndex;
        int arrayIndex;

        Pair(int a, int b){

            listIndex = a;
            arrayIndex = b;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        if(lists.isEmpty() || k <= 0)
            return Integer.MIN_VALUE;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> lists.get(a.listIndex)[a.arrayIndex] -
                          lists.get(b.listIndex)[b.arrayIndex]
        );
        for(int i = 0; i < lists.size(); i++)
            if(lists.get(i) != null)
                minHeap.offer(new Pair(i, 0));
        int count = 0, result = 0;
        while(!minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            result = lists.get(pair.listIndex)[pair.arrayIndex];
            if(++count == k)
                return result;
            pair.arrayIndex++;
            if(pair.arrayIndex < lists.get(pair.listIndex).length)
                minHeap.offer(pair);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
