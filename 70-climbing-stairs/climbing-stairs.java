class Solution {
    int solve(int n, ArrayList<Integer> dp){
        //base case
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        if(dp.get(n) != -1){
            return dp.get(n);
        }

        dp.set(n, solve(n - 1, dp) + solve(n - 2, dp));
        return dp.get(n);
    }
    public int climbStairs(int n) {

       ArrayList<Integer> dp = new ArrayList<>();

       
        for(int i = 0; i <= n; i++){
            dp.add(-1);
        }

        int ans = solve(n, dp);
        return ans;
    }
}