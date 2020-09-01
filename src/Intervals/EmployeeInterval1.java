/**
 *
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 *
 * Add all the intervals into one list.
 * Merge them together
 * Find the gap in the merged list.
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

class EmployeeFreeTime1 {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {

        if(schedule.isEmpty())
            return new ArrayList<>();

        List<Interval> result = new ArrayList<>();
        for(List<Interval> list : schedule)
            for(Interval interval : list)
                result.add(interval);

        Collections.sort(result, (a, b) -> a.start - b.start);
        List<Interval> merged = new ArrayList<>();
        Iterator<Interval> itr = result.listIterator();
        Interval at = itr.next();
        int start = at.start;
        int end   = at.end;

        while(itr.hasNext()){

            Interval next = itr.next();
            if(next.start <= end){
                end = Math.max(end, next.end);
            } else{

                merged.add(new Interval(start, end));
                start = next.start;
                end   = next.end;
            }
        }
        merged.add(new Interval(start, end));
        result.clear();
        for(int i = 1; i < merged.size(); i++)
            result.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
