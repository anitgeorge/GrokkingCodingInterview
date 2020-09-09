import java.lang.reflect.Array;
import java.util.*;

public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {

        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<>());
        for(int num : nums){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                List<Integer> list = queue.poll();
                int n = list.size();
                for(int j = 0; j <= n; j++){

                    List<Integer> curr = new ArrayList<>(list);
                    curr.add(j, num);
                    if(curr.size() == nums.length)
                        result.add(curr);
                    else
                        queue.offer(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}

