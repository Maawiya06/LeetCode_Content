class Solution {
    public int solve(String s, String t, int i, int j, int[][] dp){

        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans = ans + solve(s, t, i + 1, j + 1, dp);
        }
        ans = ans + solve(s, t, i + 1, j, dp);
        dp[i][j] = ans;
        return dp[i][j];
    }


    public int solveBU(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 0);
        }

        // base case
        for(int i = 0; i <= s.length(); i++){
            dp[i][t.length()] = 1;
        }

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = t.length() - 1; j >= 0; j--){
                int ans = 0;
                if(s.charAt(i) == t.charAt(j)){
                    ans = ans + dp[i + 1][j + 1];
                }
                ans = ans + dp[i+1][j];
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
    public int numDistinct(String s, String t) {
        // int n = s.length();
        // int m = t.length();

        // int[][] dp = new int[n + 1][m + 1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(s, t, 0, 0, dp);

        return solveBU(s, t);
    }
}