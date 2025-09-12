class Solution {
    boolean check(int[] curr, int[] prev){
        if(prev[0] <= curr[0] && prev[1] <= curr[1] && prev[2] <= curr[2]){
            return true;
        }
        else{
            return false;
        }
    }
    int solve(int[][] cuboids, int curr, int prev, int[][] dp){
        int n = cuboids.length;

        // base case
        if(curr >= n){
            return 0;
        }

        if(dp[curr][prev + 1] != -1){
            return dp[curr][prev + 1];
        }

        int include = 0;
        if(prev == -1 || check(cuboids[curr], cuboids[prev])){
            int hightToAdd = cuboids[curr][2]; 
            include = hightToAdd + solve(cuboids, curr + 1, curr, dp);
        }

        int exclude = 0 + solve(cuboids, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        if(n == 0) return 0;
        
        for(int[] cuboid : cuboids){
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(cuboids, 0, -1, dp);
    }
}