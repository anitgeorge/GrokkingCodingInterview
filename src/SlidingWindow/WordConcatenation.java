/**
 * Given a string and a list of words, find all the starting indices of 
 * substrings in the given string that are a concatenation of all the 
 * given words exactly once without any overlapping of words. 
 * It is given that all words are of the same length.
 *
 * @author anitgeorge
 */

class WordConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {

        if(s.isEmpty() || words == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int len = words[0].length();
        int wc  = words.length;
        Set<String> set = new HashSet<>();
        for(String word : words)
            set.add(word);
        int start = 0;
        for(; start < s.length() - (wc * len); start += len){

            if(helper(s.substring(start, start + wc * len), set, len))
                result.add(start);
        }

        return result;
    }

    private boolean helper(String str, Set<String> words, int len){

        Set<String> set = new HashSet<String>(words);
        int start = 0;
        while(!set.isEmpty() && start <= str.length() - len){

            String temp = str.substring(start, start+len);
            if(!set.contains(temp))
                return false;
            set.remove(temp);
            start += len;
        }

        return set.isEmpty();
    }
}