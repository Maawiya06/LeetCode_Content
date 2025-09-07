class Solution {
    int solveUingTabulation(int[] nums) {

        int n = nums.length;
        // create dp
        int[] dp = new int[n + 1];
        
        // take base case
        dp[n - 1] = nums[n - 1];

        // store and return 
        for (int index = n - 2; index >= 0; index--) {
            int include = nums[index] + (index + 2 < n ? dp[index + 2] : 0);
            int exclude = dp[index + 1];
            dp[index] = Math.max(include, exclude);
        }

        return dp[0];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return solveUingTabulation(nums);
    }
}
