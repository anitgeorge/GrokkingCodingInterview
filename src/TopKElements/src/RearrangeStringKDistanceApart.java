/**
 * Given a string and a number ‘K’,
 * find if the string can be rearranged
 * such that the same characters are at
 * least ‘K’ distance apart from each other.
 *
 * @author anitgeorge
 */

import java.util.*;
public class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k){

        if(str.isEmpty() || str.length() < k)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        String result = new String();
        for(char ch: str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        pq.addAll(map.entrySet());
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curr = pq.poll();
            result += curr.getKey();
            curr.setValue(curr.getValue() - 1);
            queue.offer(curr);
            if(queue.size() == k){
                Map.Entry<Character, Integer> entry = queue.poll();
                if(entry.getValue() > 0)
                    pq.offer(entry);
            }

        }
        return result.length() == str.length() ? result : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
