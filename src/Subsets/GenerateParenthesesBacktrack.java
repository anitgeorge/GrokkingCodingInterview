/**
 *
 * For a given number ‘N’, write a function to generate all combination
 * of ‘N’ pairs of balanced parentheses.
 *
 * Input: N=2
 * Output: (()), ()()
 *
 * @author anitgeorge
 */

import java.util.*;

class GenerateParenthesesBacktrack {

    public static List<String> generateValidParentheses(int num) {
        if(num == 0) return new ArrayList<>();
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0 , 0, num);
        return result;
    }

    private static void backtrack(List<String> list, String str, int open,
                                  int close, int max){

        if(str.length() == 2 * max){

            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open + 1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close + 1, max);
    }

    public static void main(String[] args) {
        List<String> result = GenerateParenthesesBacktrack.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParenthesesBacktrack.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
