/**
 *
 * Given an N∗NN * NN∗N matrix where each row and column
 * is sorted in ascending order, find the Kth smallest
 * element in the matrix.
 *
 * Input: Matrix=[
 *     [2, 6, 8],
 *     [3, 7, 10],
 *     [5, 8, 11]
 *   ],
 *   K=5
 * Output: 7
 * Explanation: The 5th smallest number in the matrix is 7.
 */

import java.util.*;
class Node{
    int row;
    int col;
    Node(int a, int b){
        row = a;
        col = b;
    }
}
class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || k <= 0)
            return -1;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (a, b) -> matrix[a.row][a.col] - matrix[b.row][b.col]
        );
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        for(int i = 0; i < rowLen && i < k; i++)
            minHeap.offer(new Node(i, 0));
        int count = 0;
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            if(++count == k)
                return matrix[node.row][node.col];
            node.col++;
            if(node.col < colLen)
                minHeap.offer(node);
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }


}