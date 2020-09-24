/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can
 * have some prerequisite tasks which need to be completed before
 * it can be scheduled. Given the number of tasks and a list of
 * prerequisite pairs, write a method to print all possible ordering
 * of tasks meeting all prerequisites.
 *
 * @author anitgeorge
 */

import java.util.*;

class AllTaskSchedulingOrders {
    private static void printOrders(int tasks, int[][] prerequisites) {
        if(tasks <= 0 || prerequisites == null)
            return;
        Map<Integer, Integer> indegree    = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue      = new LinkedList<>();
        List<Integer> sortedOrder = new ArrayList<>();

        for(int i = 0; i < tasks; i++){
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for(int[] order : prerequisites){
            int parent = order[0], child = order[1];
            graph.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet())
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        printAllOrders(graph, indegree, queue, sortedOrder);
    }

    private static void printAllOrders(Map<Integer, List<Integer>> graph, Map<Integer, Integer> indegree,
                                Queue<Integer> queue, List<Integer> sortedOrder){

        if(!queue.isEmpty()){
            for(Integer node : queue){
                sortedOrder.add(node);
                Queue<Integer> clone = cloneQueue(queue);
                clone.remove(node);
                for(int childNode : graph.get(node)){
                    indegree.put(childNode, indegree.get(childNode) - 1);
                    if(indegree.get(childNode) == 0)
                        clone.offer(childNode);
                }
                printAllOrders(graph, indegree, clone, sortedOrder);
                sortedOrder.remove(node);
                for(int childNode : graph.get(node))
                    indegree.put(childNode, indegree.get(childNode) + 1);
            }
        }
        if(sortedOrder.size() == indegree.size())
            System.out.println(sortedOrder);
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for(Integer num : queue)
            clone.offer(num);
        return clone;
    }


    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}