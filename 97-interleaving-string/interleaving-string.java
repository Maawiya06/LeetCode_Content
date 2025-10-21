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

    // This is the corrected Bottom-Up (Tabulation) implementation.
    public boolean solveBU(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) {
            return false;
        }

        // dp[i][j] will be true if s1's first 'i' chars and s2's first 'j' chars
        // can form an interleaving of s3's first 'i+j' chars.
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        // Base Case: two empty strings can form one empty string.
        dp[0][0] = true;

        // Fill the first row (using only s1)
        for (int i = 1; i <= n1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }

        // Fill the first column (using only s2)
        for (int j = 1; j <= n2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int k = i + j; // This is the corresponding index in s3
                
                boolean matchS1 = false;
                // Check if we can form the string by taking a char from s1
                if (s1.charAt(i - 1) == s3.charAt(k - 1)) {
                    matchS1 = dp[i - 1][j];
                }

                boolean matchS2 = false;
                // Check if we can form the string by taking a char from s2
                if (s2.charAt(j - 1) == s3.charAt(k - 1)) {
                    matchS2 = dp[i][j - 1];
                }

                dp[i][j] = matchS1 || matchS2;
            }
        }

        // The final answer is in the bottom-right corner of the table
        return dp[n1][n2];
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
        //return solve(s1, s2, s3, 0, 0, 0, dp) == 1;

        return solveBU(s1, s2, s3);
    }
}