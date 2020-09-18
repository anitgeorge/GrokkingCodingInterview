/**
 *
 * Given a string, sort it based on the decreasing frequency of its characters.
 *
 * Input: "Programming"
 * Output: "rrggmmPiano"
 * Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
 *
 * @author anitgeorge
 */

import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        if(str.isEmpty())
            return str;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b)-> b.getValue() - a.getValue()
        );
        for(char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        maxHeap.addAll(map.entrySet());
        String result = new String();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int count = entry.getValue();
            char ch = entry.getKey();
            while(count-- > 0)
                result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
