class Solution {
    int solve(String a, String b, int i, int j, int[][] dp){
        // base case
        if(i >= a.length() || j >= b.length()){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // resursive relation
        int ans = 0;
        if(a.charAt(i) == b.charAt(j)){
            ans = 1 + solve(a, b, i + 1, j + 1, dp);
        }
        else{
            ans = 0 + Math.max(solve(a, b, i, j + 1, dp), solve(a, b, i + 1, j, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i = 0;
        int j = 0;
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int index = 0; index < n; index++){
            Arrays.fill(dp[index], -1);
        }
        int ans = solve(text1, text2, i, j, dp);
        return ans;

    }
}