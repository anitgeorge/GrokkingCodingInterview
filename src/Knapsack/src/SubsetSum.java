class SubsetSum {
    static int countSubsets(int[] nums, int sum) {
        if(nums == null || nums.length == 0)
           return -1;
        int[][] dp = new int[nums.length][sum + 1];
        for(int i = 0; i < nums.length; i++)
            dp[i][0] = 1;
        for(int j = 1; j <= sum; j++)
            dp[0][j] = nums[0] == j ? 1 : 0;
        for(int i = 1; i < nums.length; i++)
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] <= j)
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }

        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}