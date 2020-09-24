import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] words) {

        if(words == null || words.length == 0)
            return "";
        Map<Character, Integer> indegree      = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        Queue<Character> queue  = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for(String word : words)
            for(char ch : word.toCharArray()){
                indegree.putIfAbsent(ch, 0);
                graph.putIfAbsent(ch, new ArrayList<>());
            }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                char parent = word1.charAt(j), child = word2.charAt(j);
                if(parent != child){
                    graph.get(parent).add(child);
                    indegree.put(child, indegree.get(child) + 1);
                    break;
                }
            }
        }
        for(Map.Entry<Character, Integer> entry : indegree.entrySet())
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());

        while(!queue.isEmpty()){
            char src = queue.poll();
            builder.append(src);
            for(char ch : graph.get(src)){
                indegree.put(ch, indegree.get(ch) - 1);
                if(indegree.get(ch) == 0)
                    queue.offer(ch);
            }
        }
        return builder.length() == indegree.size() ? builder.toString() : "";
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}