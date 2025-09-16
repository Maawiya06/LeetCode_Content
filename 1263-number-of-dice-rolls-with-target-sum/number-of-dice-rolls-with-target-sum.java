class Solution {
    static final int MOD = 1_000_000_007;

    int solve(int n, int k, int target, int[][] dp) {
        // base cases
        if (target < 0) return 0;
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target == 0) return 0;

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        long ans = 0; 
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                ans = (ans + solve(n - 1, k, target - i, dp)) % MOD;
            }
        }
        dp[n][target] = (int) ans;
        return dp[n][target];
    }
    
    int solveTabulation(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        // base case
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= target; sum++) {
                long ans = 0;
                for (int face = 1; face <= k; face++) {
                    if (sum - face >= 0) {
                        ans = (ans + dp[dice - 1][sum - face]) % MOD;
                    }
                }
                dp[dice][sum] = (int) ans;
            }
        }

        return dp[n][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {   
            Arrays.fill(dp[i], -1);
        }
        // return solve(n, k, target, dp);
        return solveTabulation(n, k, target);
    }
}
