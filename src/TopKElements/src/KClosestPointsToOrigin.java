/**
 *
 * Given an array of points in the a 2D2D2D plane, find ‘K’ closest points to the origin.
 *
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
 * The Euclidean distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
 *
 * @author anitgeorge
 */

import java.util.*;
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}
public class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        if(points == null || points.length == 0)
            return result;
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
                (a, b) -> b.distFromOrigin() - a.distFromOrigin()
        );

        for(Point point: points){
            maxHeap.offer(point);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
