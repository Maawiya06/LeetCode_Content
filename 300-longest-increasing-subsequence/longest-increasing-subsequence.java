class Solution {
    int solve(int[] nums, int curr, int prev, int[][] dp){
        // base case
        if(curr >= nums.length){
            return 0;
        }
        
        // if answer exist then left it and here do index shifting
        if(dp[curr][prev + 1] != -1){
            return dp[curr][prev + 1];
        }
        int include = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            include = 1 + solve(nums, curr + 1, curr, dp);
        }
        int exclude = 0 + solve(nums, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }


    int solveByBinarySearch(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
            } else {
                // find just-bigger element index (lower_bound equivalent)
                int index = Collections.binarySearch(ans, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                ans.set(index, nums[i]);
            }
        }
        return ans.size();
    }

    public int lengthOfLIS(int[] nums) {
        int curr = 0;
        int prev = -1;
        int n = nums.length;
        // int[][] dp = new int[n + 1][n + 1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        int ans = solveByBinarySearch(nums);
        return ans;
    }
}