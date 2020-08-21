/**
 *
 * Given an array nums of n integers and an integer target, find three
 * integers in nums such that the sum is closest to target. Return the
 * sum of the three integers. You may assume that each input would have
 * exactly one solution.
 *
 * @author anitgeorge
 */

class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int start = 0; start < nums.length - 2; start++){

            int left = start + 1, right = nums.length - 1;
            while(left < right){
                int diff  = target - ( nums[start] + nums[left] + nums[right]);
                if(diff == 0)
                    return target;
                if(Math.abs(diff) < Math.abs(min) ||
                        ( Math.abs(diff) == Math.abs(min) && diff > min)
                )
                    min = diff;
                if(diff > 0)
                    left++;
                else
                    right--;

            }
        }

        return target - min;
    }
}