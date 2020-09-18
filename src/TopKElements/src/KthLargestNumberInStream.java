/**
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 *
 * The class should have the following two things:
 *
 *     The constructor of the class should accept an integer array containing initial
 *     numbers from the stream and an integer ‘K’.
 *     The class should expose a function add(int num) which will store the given number
 *     and return the Kth largest number.
 *
 * @author anitgeorge
 */

import java.util.*;

class KthLargestNumberInStream {

    int capacity;
    PriorityQueue<Integer> queue;
    public KthLargestNumberInStream(int[] nums, int k) {
        capacity = k;
        queue    = new PriorityQueue<>();
        for(int num: nums)
            add(num);
    }

    public int add(int num) {

        if(queue.isEmpty() || queue.size() < capacity)
            queue.offer(num);
        else{
            if(num < queue.peek())
                return queue.peek();
            queue.poll();
            queue.offer(num);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}