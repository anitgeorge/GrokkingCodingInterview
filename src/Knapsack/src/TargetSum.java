/**
 * You are given a set of positive numbers and a target sum ‘S’.
 * Each number should be assigned either a ‘+’ or ‘-’ sign.
 * We need to find the total ways to assign symbols to make the
 * sum of the numbers equal to the target ‘S’.
 *
 * Input: {1, 1, 2, 3}, S=1
 * Output: 3
 * Explanation: The given set has '3' ways to make a sum of '1':
 *     {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 *
 * Solution:
 *  Sum(s1) - Sum(s2) = Target
 *  Sum(s1) + Sum(s2) = Sum(s)
 *
 *  ==> 2Sum(s1) = Target + Sum(s)
 *  Sum(s1) = (Target + Sum(s)) / 2
 */
import java.util.Arrays;

class TargetSum {

    public int findTargetSubsets(int[] nums, int s) {
        if(nums == null || nums.length == 0)
           return -1;
        int total = (Arrays.stream(nums).sum() + s)/2;
        int[][] dp = new int[nums.length][total + 1];
        for(int i = 0; i < nums.length; i++)
            dp[i][0] = 1;
        for(int j = 1; j <= total; j++)
            dp[0][j] = nums[0] == j ?  1 : 0;
        for(int i = 1; i < nums.length; i++)
            for(int j = 1; j <= total; j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] <= j)
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }
        return dp[nums.length - 1][total];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
