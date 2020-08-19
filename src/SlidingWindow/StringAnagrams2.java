/**
 *
 * Given a string and a pattern, find all anagrams of the pattern in the given string
 *
 * @author anitgeorge
 */

import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if(str.isEmpty() || pattern.isEmpty())
            return resultIndices;
        int end = pattern.length(), start = 0;
        char[] arr = pattern.toCharArray();
        Arrays.sort(arr);
        pattern = new String(arr);
        for(; end <= str.length(); end++, start++){

            if(isAnagram(str.substring(start, end), pattern) == true)
                resultIndices.add(start);
        }
        return resultIndices;
    }

    private static boolean isAnagram(String src, String dest){

        char[] arr = src.toCharArray();
        Arrays.sort(arr);
        return new String(arr).equals(dest);
    }
}
}