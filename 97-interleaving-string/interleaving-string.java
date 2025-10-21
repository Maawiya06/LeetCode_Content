class Solution {
    int solve(String s1, String s2, String s3, int i, int j, int k, int[][][] dp){
        if(i == s1.length() && j == s2.length() && k == s3.length()) return 1;
        
        if(dp[i][j][k] != -1) return dp[i][j][k];

        int flag = 0;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            flag = flag | solve(s1, s2, s3, i + 1, j, k + 1, dp);
        }  
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            flag = flag | solve(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        return dp[i][j][k] = flag;      
    }
    
    // solve by Bottom Up
    int solveBU(String s1, String s2, String s3){
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        
        // initilize DP
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                Arrays.fill(dp[i][j], 0);
            }
        }

        // base case
        dp[n1][n2][n3] = 1;
        for(int i = n1; i >= 0; i--){
            for(int j = n2; j >= 0; j--){
                for(int k = n3; k >= 0; k--){
                    if(i == s1.length() && j == s2.length() && k == s3.length()) continue;

                    int flag = 0;
                    if(i < n1 && k < n3 && s1.charAt(i) == s3.charAt(k)){
                        flag = flag | dp[i + 1][j][k + 1];
                    }
                    if(j < n2 && k < n3 && s2.charAt(j) == s3.charAt(k)){
                        flag = flag | dp[i][j + 1][k + 1];
                    }

                    dp[i][j][k] = flag;
                }
            }
        }
        return dp[0][0][0];
    }
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        // return solve(s1, s2, s3, 0, 0, 0, dp) == 1;

        return solveBU(s1, s2, s3) == 1;
    }
}