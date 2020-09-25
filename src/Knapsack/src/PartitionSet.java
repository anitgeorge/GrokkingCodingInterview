/**
 *
 * Given a set of positive numbers, partition the set into
 * two subsets with minimum difference between their subset sums.
 *
 * @author anitgeorge
 */

import java.util.*;

class PartitionSet {

    public int canPartition(int[] nums) {
       if(nums == null || nums.length == 0)
           return 0;
       int sum = Arrays.stream(nums).sum();
       int newSum = sum/2;
       boolean[][] dp = new boolean[nums.length][newSum + 1];
       for(int i = 0; i < nums.length; i++)
           dp[i][0] = true;
       for(int j = 1; j <= newSum; j++)
           dp[0][j] = nums[0] == j;
       for(int i = 1; i < nums.length; i++)
           for(int j = 1; j <= newSum; j++){
               dp[i][j] = dp[i -1][j];
               if(dp[i][j] == false && j >= nums[i])
                   dp[i][j] = dp[i - 1][j - nums[i]];
           }

       int sum1 = newSum;
       while(dp[nums.length - 1][sum1] == false)
           sum1--;
       int sum2 = sum - sum1;
       return Math.abs(sum2 - sum1);
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
