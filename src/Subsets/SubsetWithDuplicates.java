import java.util.*;

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {

        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i = 0 ; i < nums.length; i++){
            start = (i > 0 && nums[i - 1] == nums[i]) ? end : 0;
            end = subsets.size();
            for(int j = start; j < end; j++){
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

