import java.security.cert.CertPathValidatorException;
import java.util.*;
/**
 *
 * Given an expression containing digits and operations (+, -, *),
 * find all possible ways in which the expression can be evaluated
 * by grouping the numbers and operators using parentheses.
 *
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
 *
 * @author anitgeorge
 */
public class EvaluateExpressionMemo {

    Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();
    public List<Integer> evaluate(String expr){

        if(expr.isEmpty())
            return new ArrayList<>();
        if(cache.containsKey(expr))
            return cache.get(expr);
        List<Integer> result = new ArrayList<>();
        if(!expr.contains("+") && !expr.contains("-") && !expr.contains("*")){
            result.add(Integer.parseInt(expr));
            return result;
        }
        for(int i = 0; i < expr.length(); i++){

            char ch = expr.charAt(i);
            if(!Character.isDigit(ch)){

                List<Integer> left = evaluate(expr.substring(0, i));
                List<Integer> right = evaluate(expr.substring(i + 1));

                for(int num1 : left)
                    for(int num2 : right)
                        result.add(compute(num1, num2, ch));
            }
        }
        cache.put(expr, result);
        return result;
    }

    private int compute(int num1, int num2, char ch) {
        if(ch == '+')
            return num1 + num2;
        return ch == '-' ? num1 - num2 : num1 * num2;
    }

    public static void main(String[] args) {
        EvaluateExpressionMemo ee = new EvaluateExpressionMemo();
        List<Integer> result = ee.evaluate("1+2*3");
        System.out.println("Expression evaluations: " + result);

        ee = new EvaluateExpressionMemo();
        result = ee.evaluate("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
