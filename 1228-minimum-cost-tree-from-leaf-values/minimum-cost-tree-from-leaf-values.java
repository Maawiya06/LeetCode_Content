class Solution {

    int solve(int[] arr, Map<String, Integer> maxi, int start, int end, int[][] dp) {
        // base case
        if (start >= end) {
            return 0;
        }
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.min(ans,
                    (maxi.get(start + "," + i) * maxi.get((i + 1) + "," + end))
                            + solve(arr, maxi, start, i, dp)
                            + solve(arr, maxi, i + 1, end, dp));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }

    public int mctFromLeafValues(int[] arr) {
        Map<String, Integer> maxi = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            maxi.put(i + "," + i, arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                maxi.put(i + "," + j, Math.max(arr[j], maxi.get(i + "," + (j - 1))));
            }
        }

        
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(arr, maxi, start, end, dp);
    }
}
