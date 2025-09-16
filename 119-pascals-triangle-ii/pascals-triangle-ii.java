class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        

        for(int i = 0; i <= n; i++){
            for(int j = i; j > 0; j--){
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            result.add(dp[i]);
        }

        return result;
    }
}