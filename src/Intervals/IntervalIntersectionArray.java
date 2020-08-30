/**
 *
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a
 * set of real numbers that is either empty, or can be represented as a closed
 * interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 * @author anitgeorge
 */

class IntervalIntersectionArray {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if(A == null || A.length == 0
                || B == null || B.length == 0
        )
            return new int[][]{};

        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;
        while( i < A.length && j < B.length){

            if((A[i][0] >= B[j][0] && A[i][0] <= B[j][1])
                    || (B[j][0] >= A[i][0] && B[j][0] <= A[i][1])
            )
                result.add(new int[]{Math.max(A[i][0], B[j][0]),
                        Math.min(A[i][1], B[j][1])});

            if(A[i][1] < B[j][1])
                i++;
            else
                j++;

        }

        return result.toArray(new int[result.size()][2]);
    }
}