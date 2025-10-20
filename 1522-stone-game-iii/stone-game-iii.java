class Solution {
    int solve(int[] sv, int i, int[] dp){
        if(i == sv.length) return 0;
        
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MIN_VALUE;
        int total = 0;

        for(int X = 1; X <= 3; ++X){
            if(i + X - 1 >= sv.length) break;
            total = total + sv[i + X - 1];
            ans = Math.max(ans, total - solve(sv, i + X, dp));
        }
        return dp[i] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = solve(stoneValue, 0, dp);

        if(ans > 0) return "Alice";
        if(ans < 0) return "Bob";
        return "Tie";
    }
}