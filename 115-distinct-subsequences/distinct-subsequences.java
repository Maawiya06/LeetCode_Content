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
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(s, t, 0, 0, dp);
    }
}