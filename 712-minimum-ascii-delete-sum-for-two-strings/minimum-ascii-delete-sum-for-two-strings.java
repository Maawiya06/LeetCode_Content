class Solution {
    int solve(String s1, String s2, int i, int j, int[][] dp){
        int cost = 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == s1.length() || j == s2.length()){
            for(int x = i; x < s1.length(); x++){
                cost += s1.charAt(x);
            }
            for(int x = j; x < s2.length(); x++){
                cost += s2.charAt(x);
            }
        }
        else if(s1.charAt(i) == s2.charAt(j)){
            cost = solve(s1, s2, i + 1, j + 1, dp);
        }
        else{
            int cost1 = s1.charAt(i) + solve(s1, s2, i + 1, j, dp);
            int cost2 = s2.charAt(j) + solve(s1, s2, i , j + 1, dp);
            cost = Math.min(cost1, cost2);
        }
        dp[i][j] = cost;
        return dp[i][j];
    }


    int solveByTabulation(String s1, String s2){
       int[][] dp = new int[s1.length() + 1][s2.length() + 1];

       for(int i = 0; i <= s1.length(); i++){
            Arrays.fill(dp[i], 0);
        }
        // base case
        for(int i = s1.length() - 1; i >= 0; i--){
            dp[i][s2.length()] = s1.charAt(i) + dp[i + 1][s2.length()];
        }
        for(int i = s2.length() - 1; i >= 0; i--){
            dp[s1.length()][i] = s2.charAt(i) + dp[s1.length()][i + 1];
        }


        for(int i = s1.length() - 1; i >= 0; i--){
            for(int j = s2.length() - 1; j >= 0; j--){
                int cost = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    cost = dp[i + 1][j + 1];
                }
                else{
                    int cost1 = s1.charAt(i) + dp[i + 1][j];
                    int cost2 = s2.charAt(j) + dp[i][j + 1];
                    cost = Math.min(cost1, cost2);
                }
                dp[i][j] = cost;
            }
        }
        return dp[0][0];
    }
    public int minimumDeleteSum(String s1, String s2) {

        // int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // for(int i = 0; i <= s1.length(); i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(s1, s2, 0, 0, dp);

        return solveByTabulation(s1, s2);
    }
}