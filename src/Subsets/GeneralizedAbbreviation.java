import java.util.*;

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", word, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String curr, String word, int pos, int count){

        if(pos == word.length()){
            if(count > 0)
                curr+=count;
            result.add(curr);
            return;
        }
        backtrack(result, curr, word, pos + 1, count + 1);
        backtrack(result, curr + (count > 0? count : "")+word.charAt(pos), word, pos + 1, 0);

    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
