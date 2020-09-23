/**
 *
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can
 * have some prerequisite tasks which need to be completed before
 * it can be scheduled. Given the number of tasks and a list of
 * prerequisite pairs, write a method to find the ordering of
 * tasks we should pick to finish all tasks.
 *
 * @author anitgeorge
 */

import java.util.*;

class TaskSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        if(tasks == 0 || prerequisites == null)
            return new ArrayList<>();
        List<Integer> sortedOrder         = new ArrayList<>();
        Map<Integer, Integer> indegree    = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue              = new LinkedList<>();

        for(int i = 0; i < tasks; i++){
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int parent = pre[0], child = pre[1];
            graph.get(parent).add(child);
            indegree.put(child, indegree.getOrDefault(child, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        while(!queue.isEmpty()){
            int job = queue.poll();
            sortedOrder.add(job);
            for(int dependency : graph.get(job)){
                indegree.put(dependency, indegree.get(dependency) - 1);
                if(indegree.get(dependency) == 0)
                    queue.offer(dependency);
            }
        }
        return sortedOrder.size() == tasks ? sortedOrder : new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
                new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println(result);
    }
}
