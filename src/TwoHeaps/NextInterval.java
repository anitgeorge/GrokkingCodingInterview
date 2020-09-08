/**
 *
 * Given an array of intervals, find the next interval of each interval.
 * In a list of intervals, for an interval ‘i’ its next interval ‘j’ will
 * have the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.
 *
 * Write a function to return an array containing indices of the next interval
 * of each input interval. If there is no next interval of a given interval,
 * return -1. It is given that none of the intervals have the same start point.
 *
 * @author anitgeorge
 */

import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[]{};
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> maxStart = new PriorityQueue<>(
                (a, b) -> intervals[b].start - intervals[a].start
        );
        PriorityQueue<Integer> maxEnd = new PriorityQueue<>(
                (a, b) -> intervals[b].end - intervals[a].end
        );
        for(int i = 0; i < intervals.length; i++){
            maxEnd.offer(i);
            maxStart.offer(i);
        }
        while(!maxEnd.isEmpty()){
            int topEnd = maxEnd.poll();
            result[topEnd] = -1;
            if(intervals[maxStart.peek()].start >= intervals[topEnd].end){
                int topStart = maxStart.poll();
                while(!maxStart.isEmpty()
                        && intervals[maxStart.peek()].start >= intervals[topEnd].end)
                    topStart = maxStart.poll();
                result[topEnd] = topStart;
                maxStart.offer(topStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}