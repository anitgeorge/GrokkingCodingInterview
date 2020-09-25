/**
 *
 * Given a sequence originalSeq and an array of sequences, write a method
 * to find if originalSeq can be uniquely reconstructed from the array of sequences.
 *
 * Unique reconstruction means that we need to find if originalSeq is the only
 * sequence such that all sequences in the array are subsequences of it.
 *
 * @author anitgeorge
 */

import java.util.*;

class SequenceReconstruction {

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        if(originalSeq == null || sequences == null)
            return false;
        Map<Integer, Integer> indegree    = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue      = new LinkedList<>();
        List<Integer> sortedOrder = new ArrayList<>();

        for(int[] seq : sequences)
            for(int num : seq){
                indegree.putIfAbsent(num, 0);
                graph.putIfAbsent(num, new ArrayList<>());
            }
        if(indegree.size() != originalSeq.length)
            return false;
        for(int[] seq : sequences){
            for(int i = 0; i < seq.length - 1; i++){
                int parent = seq[i], child = seq[i + 1];
                graph.get(parent).add(child);
                indegree.put(child, indegree.get(child) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet())
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        while(!queue.isEmpty()){
            if(queue.size() > 1)
                return false;
            if(originalSeq[sortedOrder.size()] != queue.peek())
                return false;
            int num = queue.poll();
            sortedOrder.add(num);
            for(int node : graph.get(num)){
                indegree.put(node, indegree.get(node) - 1);
                if(indegree.get(node) == 0)
                    queue.offer(node);
            }
        }
        return sortedOrder.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}