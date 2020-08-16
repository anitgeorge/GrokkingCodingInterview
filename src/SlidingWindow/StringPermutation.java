/**
 * Given a string and a pattern,
 * find out if the string contains any permutation of the pattern.
 *
 * @author anitgeorge
 */

import java.util.*;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        if(str.isEmpty() || pattern.isEmpty() || str.length() < pattern.length())
            return false;

        int arr[] = new int[26];
        for(char ch: pattern.toCharArray())
            arr[ch - 'a']++;
        int windowLength = pattern.length();
        for(int i = 0; i < str.length(); i++){

            arr[str.charAt(i) - 'a']--;
            if( i >= windowLength)
                arr[str.charAt(i - windowLength) - 'a']++;
            if(allZeors(arr))
                return true;
        }

        return false;
    }

    private static boolean allZeors(int[] arr){

        for(int num : arr)
            if(num !=0)
                return false;
        return true;
    }
}
