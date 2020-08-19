/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 *
 * @author anitgeorge
 */

import java.util.*;

class MinimumWindowSubString {
    public static String findSubstring(String s, String t) {
        if(s.isEmpty() || t.isEmpty())
            return "";
        int[] map = new int[128];
        for(char ch: t.toCharArray())
            map[ch]++;
        int start = 0, end = 0, counter = t.length();
        int  dist = Integer.MAX_VALUE, head = 0;

        while(end < s.length()){

            if(map[s.charAt(end++)]-- > 0)
                counter--;
            while(counter == 0){
                if(end - start < dist){
                    dist = end - start;
                    head = start;
                }
                if(map[s.charAt(start++)]++ == 0)
                    counter++;
            }
        }
        return dist == Integer.MAX_VALUE ? "": s.substring(head, head + dist);
    }
}