/**
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author anitgeorge
 */

class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {

        if( n == 0)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n, k, 1, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int n, int k, int start, List<List<Integer>> list, List<Integer> path){

        if(path.size() == k && n == 0){
            list.add(new ArrayList<>(path));
            return;
        }
        if(n < 0 || path.size() > k)
            return;

        for(int i = start; i <= 9; i++){

            path.add(i);
            backtrack(n - i, k, i + 1, list, path);
            path.remove(path.size() - 1);
        }
    }
}