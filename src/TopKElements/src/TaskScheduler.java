/**
 *
 * You are given a list of tasks that need to be run,
 * in any order, on a server. Each task will take one
 * CPU interval to execute but once a task has finished,
 * it has a cooling period during which it can’t be run again.
 * If the cooling period for all tasks is ‘K’ intervals,
 * find the minimum number of CPU intervals that the server
 * needs to finish all tasks.
 *
 * If at any time the server can’t execute any task then it must stay idle.
 *
 * @author anitgeorge
 */

import java.util.*;

public class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        if(tasks == null || tasks.length == 0)
            return 0;
        if( k <= 0)
            return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        for(char task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);

        pq.addAll(map.entrySet());
        int count = 0;
        while(!pq.isEmpty()){
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            int n = k + 1;
            for(; n > 0 && !pq.isEmpty(); n--){
                count++;
                Map.Entry<Character, Integer> curr = pq.poll();
                curr.setValue(curr.getValue() - 1);
                if(curr.getValue() > 0)
                    list.add(curr);
            }
            pq.addAll(list);
            if(!pq.isEmpty())
                count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}
