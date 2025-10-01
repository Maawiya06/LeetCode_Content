class Solution {
    int solve(int[] days, int[] costs, int index, int[] dp){
        // base case
        if(index >= days.length) return 0;
        
        if(dp[index] != -1){
            return dp[index];
        }
        // pass for 1 days
        int cost1 = costs[0] + solve(days, costs, index + 1, dp);

        // 7 days pass
        int passEndDays = days[index] + 7 - 1;
        int j = index;
        while(j < days.length && days[j] <= passEndDays){
            j++;
        }
        int cost7 = costs[1] + solve(days, costs, j, dp);

        // 30 days pass
        passEndDays = days[index] + 30 - 1;
        j = index;
        while(j < days.length && days[j] <= passEndDays){
            j++;
        }
        int cost30 = costs[2] + solve(days, costs, j, dp);

        dp[index] = Math.min(cost1, Math.min(cost7, cost30));
        return dp[index];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0, dp);
    }
}