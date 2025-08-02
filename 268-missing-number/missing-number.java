class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
        }

        int totalsum = ((n) * (n+1))/2;
        int ans = totalsum - sum;
        return ans;
    }
}