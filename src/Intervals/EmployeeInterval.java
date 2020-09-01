/**
 * For ‘K’ employees, we are given a list of intervals representing the
 * working hours of each employee. Our goal is to find out if there is a
 * free interval that is common to all employees. You can assume that
 * each list of employee working hours is sorted on the start time.
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

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<List<Interval>> free = new ArrayList<>();
        for(List<Interval> list : schedule){

            free.add(getFreeForEmployee(list));
        }
        List<Interval> first = free.get(0);
        for(int i = 1; i < free.size(); i++){

            first = getIntersection(first,free.get(i));
        }

        return first;
    }

    private static List<Interval> getFreeForEmployee(List<Interval> intervals){

        Collections.sort(intervals, (a , b) -> a.start - b.start);
        List<Interval> ret = new ArrayList<>();
        for(int i = 1; i < intervals.size(); i++){

            ret.add(new Interval(intervals.get(i-1).end, intervals.get(i).start));
        }

        return ret;
    }

    private static List<Interval> getIntersection(List<Interval> list1, List<Interval> list2){

        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        Interval[] arr1 = list1.toArray(new Interval[list1.size()]);
        Interval[] arr2 = list2.toArray(new Interval[list2.size()]);
        int i = 0, j = 0;
        while( i < arr1.length && j < arr2.length){

            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)||
                    (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)
            )
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end))
                );

            if(arr1[i].end < arr2[j].end){
                ++i;
            }
            else{

                ++j;
            }
        }

        return intervalsIntersection;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
