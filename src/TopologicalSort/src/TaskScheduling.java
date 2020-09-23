/**
 *
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have
 * some prerequisite tasks which need to be completed before it can
 * be scheduled. Given the number of tasks and a list of prerequisite pairs,
 * find out if it is possible to schedule all the tasks.
 *
 *
 * @author anitgeorge
 */

import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        if(tasks == 0 || prerequisites == null)
            return false;
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
        return sortedOrder.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
