class Solution {
    int solve(int[] nums, int start, int end, int[][] dp){
        if(start > end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];
        // include
        int opt1 = nums[start] + solve(nums, start + 2, end, dp);

        // exclude
        int opt2 = 0 + solve(nums, start + 1, end, dp);

        dp[start][end] = Math.max(opt1, opt2);
        return dp[start][end];
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        if(n == 1){
            return nums[0];
        }

        int opt1 = solve(nums, 0, n - 2, dp);
        int opt2 = solve(nums, 1, n - 1, dp);

        return Math.max(opt1, opt2);
    }
}