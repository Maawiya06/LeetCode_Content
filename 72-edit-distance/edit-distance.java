class Solution {
    int solve(String a, String b, int i, int j, int[][] dp){

        // base case
        if(i == a.length()){
            return b.length() - j;
        }
        if(j == b.length()){
            return a.length() - i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // recursive 
        int ans = 0;
        if(a.charAt(i) == b.charAt(j)){
            ans = 0 + solve(a, b, i + 1, j + 1, dp);
        }
        else{
            int replace = 1 + solve(a, b, i + 1, j + 1, dp);
            int insert = 1 + solve(a, b, i, j + 1, dp);
            int remove = 1 + solve(a, b, i + 1, j, dp);
            ans = Math.min(insert, Math.min(remove, replace));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int i = 0; 
        int j = 0;
        
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int index = 0; index < n; index++){
            Arrays.fill(dp[index], -1);
        }
        int ans = solve(word1, word2, i, j, dp);
        return ans;
    }
}