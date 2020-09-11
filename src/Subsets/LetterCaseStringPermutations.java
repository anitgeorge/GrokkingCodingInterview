import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {

        if(str.isEmpty())
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(new String(""));
        for(char ch: str.toCharArray()){
            int size = queue.size();
            for(int i = 0; i < size; i++){

                String temp = queue.poll();
                if(Character.isDigit(ch)){
                    temp = temp + String.valueOf(ch);
                    if(temp.length() == str.length())
                        result.add(temp);
                    else
                        queue.offer(temp);
                } else if(Character.isLetter(ch)){

                    String lower = new String(temp);
                    lower = lower + String.valueOf(Character.toLowerCase(ch));
                    if(lower.length() == str.length())
                        result.add(lower);
                    else
                        queue.offer(lower);
                    String upper = new String(temp);
                    upper = upper + String.valueOf(Character.toUpperCase(ch));
                    if(upper.length() == str.length())
                        result.add(upper);
                    else
                        queue.offer(upper);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
