/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * @author anitgeorge
 */

import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        if(str.isEmpty())
            return -1;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        while(end < str.length()){

            if(!set.contains(str.charAt(end))){

                max = Math.max(max, end - start + 1);
                set.add(str.charAt(end++));
            } else{

                set.remove(str.charAt(start++));
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
