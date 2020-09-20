import java.util.*;

public class RearrangeStrings {

    public static String rearrangeString(String str){

        if(str.isEmpty())
            return str;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        for(char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        queue.addAll(map.entrySet());
        String result = new String();
        Map.Entry<Character, Integer> prev = null;
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> curr = queue.poll();
            result += curr.getKey();
            curr.setValue(curr.getValue() - 1);
            if(prev != null && prev.getValue() > 0)
                queue.offer(prev);
            prev = curr;
        }
        return result.length() == str.length() ? result : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeStrings.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeStrings.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeStrings.rearrangeString("aapa"));
    }
}
