/**
 *
 * Given an array of numbers and a number ‘k’,
 * find the median of all the ‘k’ sized sub-arrays
 * (or windows) of the array.
 *
 * @author anitgeorge
 */

import java.util.*;

class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    public double[] findSlidingWindowMedian(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return new double[]{};
        double[] result = new double[nums.length - k + 1];
        int start = 0, end = 0, count = 0;
        while(end < nums.length){

            insert(nums[end]);
            if(end >= k - 1){

                result[count++] = getMedian();
                remove(nums[start++]);
            }
            end++;
        }
        return result;
    }

    private void insert(int num){

        if(maxHeap.isEmpty() || maxHeap.peek() > num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        reOrder();
    }

    private void reOrder(){

        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
        else if(maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
    }

    private double getMedian(){
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        return (double)maxHeap.peek();
    }

    private void remove(int num){

        if(num <= maxHeap.peek())
            maxHeap.remove(num);
        else
            minHeap.remove(num);
        reOrder();
    }
    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}