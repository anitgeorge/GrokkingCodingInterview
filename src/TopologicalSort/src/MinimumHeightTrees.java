/**
 * We are given an undirected graph that has characteristics
 * of a k-ary tree. In such a graph, we can choose any node
 * as the root to make a k-ary tree. The root (or the tree)
 * with the minimum height will be called Minimum Height Tree (MHT).
 * There can be multiple MHTs for a graph. In this problem, we need
 * to find all those roots which give us MHTs. Write a method to find
 * all MHTs of the given graph and return a list of their roots.
 *
 * @author anitgeorge
 */

import java.util.*;

class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if(nodes <= 0)
            return minHeightTrees;
        if(nodes == 1){
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nodes; i++){
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int node1 = edge[0], node2 = edge[1];
            graph.get(node1).add(node2);
            indegree.put(node2, indegree.get(node2) + 1);
            graph.get(node2).add(node1);
            indegree.put(node1, indegree.get(node1) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : indegree.entrySet())
            if(entry.getValue() == 1)
                queue.offer(entry.getKey());

        while(nodes > 2){
            int levelSize = queue.size();
            nodes -= levelSize;
            for(int i = 0; i < levelSize; i++){
                int src = queue.poll();
                for(int dest : graph.get(src)){
                    indegree.put(dest, indegree.get(dest) - 1);
                    if(indegree.get(dest) == 1)
                        queue.offer(dest);
                }
            }
        }

        minHeightTrees.addAll(queue);
        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}