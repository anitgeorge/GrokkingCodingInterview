import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropes) {
        if(ropes == null || ropes.length <= 1)
            return 0;
        PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
        for(int rope : ropes)
            minHeap.offer(rope);
        int cost = 0;
        while(minHeap.size() > 1){
            int rope = minHeap.poll() + minHeap.poll();
            cost += rope;
            minHeap.offer(rope);
        }
        return cost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
