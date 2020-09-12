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

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PString{
    String str;
    int open;
    int close;
    PString(String s, int o, int c){
        str = s;
        open = o;
        close = c;
    }
}
public class GenerateParentheses {

    public static List<String> generateValidParentheses(int num){

        if(num <= 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Queue<PString> queue = new LinkedList<>();
        queue.offer(new PString("", 0, 0));
        while(!queue.isEmpty()){
            PString pString = queue.poll();
            if(pString.open == num && pString.close == num){
                result.add(pString.str);
                continue;
            }
            if(pString.open < num)
                queue.offer(new PString(pString.str + "(", pString.open + 1, pString.close));
            if(pString.close < pString.open)
                queue.offer(new PString(pString.str + ")", pString.open, pString.close + 1));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParenthesesBacktrack.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParenthesesBacktrack.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
