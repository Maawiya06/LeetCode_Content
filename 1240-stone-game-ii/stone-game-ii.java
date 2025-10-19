class Solution {
    int solve(int[] piles, int i, int M, boolean alice, int[][][] dp) {
        if (i == piles.length) return 0;

        int index = alice ? 1 : 0;

        if (dp[i][M][index] != -1) {
            return dp[i][M][index];
        }

        int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; ++X) {
            if (i + X > piles.length) break; 
            total += piles[i + X - 1];
            if (alice) {
                ans = Math.max(ans, total + solve(piles, i + X, Math.max(M, X), false, dp));
            } else {
                ans = Math.min(ans, solve(piles, i + X, Math.max(M, X), true, dp));
            }
        }

        dp[i][M][index] = ans;
        return ans;
    }
    
    // solve by Bottom Up
    int solveBU(int[] piles){
        int n = piles.length;

        int[][][] dp = new int[n + 1][n + 1][2];
        for(int i = 0; i <= n; i++){
            for(int j = i; j <= n; j++){
                Arrays.fill(dp[i][j], 0);
            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int M = n; M >= 1; M--){
                for(int aliceint = 0; aliceint <= 1; aliceint++){
                    
                    // int to boolean 
                    boolean alice = (aliceint == 1);

                    int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    int total = 0;
                    for(int X = 1; X <= 2 * M; X++){
                        if (i + X > piles.length) break; 
                        total += piles[i + X - 1];
                        if (alice) {
                            ans = Math.max(ans, total + dp[i + X][Math.max(X, M)][0]);
                        } else {
                            ans = Math.min(ans, dp[i + X][Math.max(X, M)][1]);
                        }
                    }
                    dp[i][M][aliceint] = ans;
                }
            }
        }
        return dp[0][1][1];
    }
    public int stoneGameII(int[] piles) {
        // int n = piles.length;
        // int[][][] dp = new int[n + 1][n + 1][2];

        
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        // return solve(piles, 0, 1, true, dp);

        return solveBU(piles);
    }
}
