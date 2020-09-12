import java.util.*;

public class EvaluateExpression {

    public static List<Integer> evaluate(String expr){

        if(expr.isEmpty())
            return new ArrayList<>();
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

                for(int p1: left)
                    for(int p2 : right)
                        result.add(compute(p1, p2, ch));
            }
        }
        return result;
    }

    private static int compute(int p1, int p2, char ch) {
        if(ch == '+')
            return p1 + p2;
        return ch == '-' ? p1 - p2 : p1 * p2;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.evaluate("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.evaluate("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
