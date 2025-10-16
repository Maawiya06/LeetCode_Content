class Solution {
    int solve(int start, int end, int[][] dp){
        if(start > end) return 1;
        if(start == end) return 1;
        
        if(dp[start][end] != -1) return dp[start][end];
        int ans = 0;
        for(int i = start; i <= end; i++){
            int left = solve(start, i - 1, dp);
            int right = solve(i + 1, end, dp);

            ans = ans + left * right;
        }
        return dp[start][end] = ans;
    }
    public int numTrees(int n) {
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(1, n, dp);
    }
}