/**
 *
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 *
 * @author anitgeorge
 */

import java.util.*;

class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums){

            int N = subsets.size();
            for(int i = 0; i < N; i++){
                List<Integer> list = new ArrayList<>(subsets.get(i));
                list.add(num);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
