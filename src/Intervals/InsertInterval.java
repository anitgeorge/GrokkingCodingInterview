/**
 * Given a set of non-overlapping intervals, insert a new interval
 * into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according
 * to their start times.
 *
 * @author anitgeorge
 */

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(newInterval == null || newInterval.length == 0)
            return intervals;

        int i = 0;
        List<int[]> result = new ArrayList<>();
        // Should the intervals be not sorted, uncomment the below line
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        while( i < intervals.length && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);

        while(i < intervals.length && newInterval[1] >= intervals[i][0] ){

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        result.add(newInterval);

        while(i < intervals.length)
            result.add(intervals[i++]);

        return result.toArray(new int[result.size()][2]);
    }
}