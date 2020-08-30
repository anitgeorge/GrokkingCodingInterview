class MergeIntervalsArray {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2)
            return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end   = intervals[0][1];
        int  i    = 1;

        while(i < intervals.length){

            while(i < intervals.length && intervals[i][0] <= end)
                end = Math.max(end, intervals[i++][1]);
            result.add(new int[]{start, end});
            if(i >= intervals.length)
                break;
            start = intervals[i][0];
            end   = intervals[i][1];
        }

        int[][] res = new int[result.size()][2];
        for(i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }
}