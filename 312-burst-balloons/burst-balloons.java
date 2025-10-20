class Solution {
    int solve(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];

        int coin = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            coin = Math.max(coin,
                    nums[start - 1] * nums[i] * nums[end + 1]
                    + solve(nums, start, i - 1, dp)
                    + solve(nums, i + 1, end, dp)
                    );
        }
        return dp[start][end] = coin;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2]; 
        newNums[0] = 1;
        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];
        newNums[n + 1] = 1;
        

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(newNums, 1, n, dp);
    }
}
