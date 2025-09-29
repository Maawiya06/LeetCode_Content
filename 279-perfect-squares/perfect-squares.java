class Solution {
    int solve(int n, int[] dp){
        if(n == 0) return 1;
        if(n < 0) return 0;
        
        if(dp[n] != -1){
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;
        int i = 1;
        int end = (int) Math.sqrt(n);

        while(i <= end){
            int prefectSquare = i * i;
            int numberofPerfectSquare = 1 + solve(n - prefectSquare, dp);
            if(numberofPerfectSquare < ans){
                ans = numberofPerfectSquare;
            }
            i++;
        }
        dp[n] = ans;
        return dp[n];
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
    
        return solve(n, dp) - 1;
    }
}