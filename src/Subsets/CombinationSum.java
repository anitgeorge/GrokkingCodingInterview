/**
 *
 * <p>
 *     https://leetcode.com/problems/combination-sum/
 * </p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target
 * number (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author anitgeorge
 */

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        if(nums == null || target == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, target, 0, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int[] nums, int target, int start,
                           List<List<Integer>> list, List<Integer> path){

        if(target < 0)
            return;
        if(target == 0){
            list.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i, list, path);
            path.remove(path.size() - 1);
        }
    }
}