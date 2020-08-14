/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put .
 * The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you
 * have to pick from a third fruit type.
 *
 * author @anitgeorge
 */


import java.util.*;

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        if(arr == null  || arr.length < 2)
            return -1;
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        while(end < arr.length){

            set.add(arr[end]);
            if(set.size() == 2)
                max = Math.max(max, end - start + 1);
            while(set.size() > 2)
                set.remove(arr[start++]);
            end++;
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}