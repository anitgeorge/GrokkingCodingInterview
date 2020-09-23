/**
 * Topological Sort of a directed graph (a graph with unidirectional edges)
 * is a linear ordering of its vertices such that for every directed
 * edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
 *
 * Given a directed graph, find the topological ordering of its vertices.
 *
 * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output: Following are the two valid topological sorts for the given graph:
 * 1) 3, 2, 0, 1
 * 2) 3, 2, 1, 0
 *
 * @author anitgeorge
 */

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {

        if(vertices <= 0 || edges == null)
            return new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < vertices; i++){
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int parent = edge[0], child = edge[1];
            graph.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(int dest : graph.get(node)){
                indegree.put(dest, indegree.get(dest) - 1);
                if(indegree.get(dest) == 0)
                    queue.offer(dest);
            }
        }
        return result.size() == vertices ? result : new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
