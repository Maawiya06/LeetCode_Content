class Solution {
    public int solve(int[] energy, int k, int i, int[] dp){
        int n = energy.length;

        // base case
        if(i >= n) return 0;

        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        
        dp[i] = energy[i] + solve(energy, k, i + k, dp);
        return dp[i];

    }
    public int maximumEnergy(int[] energy, int k) {
        
        int n = energy.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < energy.length; i++){
            result = Math.max(result, solve(energy, k, i, dp));
        }
        return result;
    }
}