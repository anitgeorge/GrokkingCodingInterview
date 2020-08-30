import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervalsList {

    public static List<Interval> merge(List<Interval> intervals) {

        if(intervals.isEmpty() || intervals.size() < 2)
            return intervals;
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Iterator<Interval> itr = intervals.listIterator();
        Interval at = itr.next();
        int start = at.start;
        int end   = at.end;
        while(itr.hasNext()){

            Interval next = itr.next();
            if(next.start <= end){
                end = Math.max(end,next.end);
            } else{

                mergedIntervals.add(new Interval(start, end));
                start = next.start;
                end   = next.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsList.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsList.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsList.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}