/**
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary
 * intervals to produce a list that has only mutually exclusive intervals.
 *
 * @author anitgeorge
 */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class InsertIntervalList {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            if(newInterval != null){
                mergedIntervals.add(newInterval);
                return mergedIntervals;
            }else {

                return new ArrayList<>();
            }
        }

        int i = 0;
        while( i < intervals.size() && intervals.get(i).end < newInterval.start){

            mergedIntervals.add(intervals.get(i++));
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){

            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end   = Math.max(newInterval.end, intervals.get(i++).end);
        }
        mergedIntervals.add(newInterval);
        while(i < intervals.size()){

            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
