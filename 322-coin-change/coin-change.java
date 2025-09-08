class Solution {
    int solveUingMem(int[] coins, int amount, int[] dp){

        // base case
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != -1){
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];

            if(coin <= amount){
                int recans = solveUingMem(coins, amount - coin, dp);

                if(recans != Integer.MAX_VALUE){
                    int ans = 1 + recans;
                    min = Math.min(min, ans);
                }
            }
        }
        dp[amount] = min;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n = amount;

        int dp[] = new int[n + 1];


        Arrays.fill(dp, - 1);


        int ans = solveUingMem(coins, amount, dp);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }
}