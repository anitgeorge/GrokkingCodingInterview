/**
 *
 * Design a class to calculate the median of a number stream.
 * The class should have the following two methods:
 *
 *     insertNum(int num): stores the number in the class
 *     findMedian(): returns the median of all numbers inserted in the class
 *
 * If the count of numbers inserted in the class is even, the median will
 * be the average of the middle two numbers.
 *
 * @author anitgeorge
 */

import java.util.*;

class MedianOfAStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    MedianOfAStream(){

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    public void insertNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
        else if(maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
