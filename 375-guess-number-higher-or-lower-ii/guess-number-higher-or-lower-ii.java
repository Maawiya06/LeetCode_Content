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

    int solveUsingTabulation(int n){
        //create dp
        int[][] dp = new int[n + 2][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 0);
        }
        
        for(int start_index = n; start_index >= 1; start_index--){
            for(int end_index = 1; end_index <= n; end_index++){

                // base case
                if(start_index >= end_index){
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for(int i = start_index; i <= end_index; i++){
                    ans = Math.min(ans, i + Math.max(dp[start_index][i - 1], dp[i + 1][end_index]));
                }

                dp[start_index][end_index] = ans;
            }
        }
        return dp[1][n];

    }
    public int getMoneyAmount(int n) {
        int start = 1;
        int end = n;

        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solveUsingTabulation(n);
        return ans;
    }
}