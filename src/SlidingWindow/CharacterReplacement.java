/**
 * Given a string with lowercase letters only, if you are allowed to replace
 * no more than ‘k’ letters with any letter, find the length of the longest
 * substring having the same letters after replacement.
 *
 * @author anitgeorge
 */

import java.util.*;

class CharacterReplacement {
    public static int findLength(String str, int k) {

        if(str.isEmpty() || k > str.length())
            return 0;
        int start    = 0;
        int end      = 0;
        int maxLen   = 0;
        int maxCount = 0;
        int[] arr    = new int[26];

        for(; end < str.length(); end++){

            arr[str.charAt(end) - 'a']++;
            maxCount = Math.max(maxCount, arr[str.charAt(end) - 'a']);
            if(end - start + 1 -maxCount > k)
                arr[str.charAt(start++) - 'a']--;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
