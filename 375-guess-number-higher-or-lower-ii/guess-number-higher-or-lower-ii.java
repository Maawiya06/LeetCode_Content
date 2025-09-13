class Solution {
    int solve(int start, int end, int[][] dp){
        // base case
        if(start >= end){
            return 0;
        }
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            ans = Math.min(ans, i + Math.max(solve(start, i - 1, dp), solve(i + 1, end, dp)));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }
    public int getMoneyAmount(int n) {
        int start = 1;
        int end = n;

        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(start, end, dp);
        return ans;
    }
}