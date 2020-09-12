/**
 *
 * <p>
 *     https://leetcode.com/problems/combination-sum-ii/
 * </p>
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author anitgeorge
 */
import java.util.*;
class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, target, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int[] nums, int start, int target,
                           List<List<Integer>> result, List<Integer> path){

        if(target < 0)
            return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtrack(nums, i + 1, target - nums[i], result, path);
            path.remove(path.size() - 1);
        }
    }
}