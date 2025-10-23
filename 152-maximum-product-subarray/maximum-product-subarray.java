class Solution {
    int solve(int[] nums, int index, int[] maxRef, int currMax, int currMin){
        if(index == nums.length) return maxRef[0];

        int val = nums[index];

        if(val < 0){
            int temp = currMax;
            currMax = currMin;
            currMin = temp;
        }

        currMax = Math.max(val, currMax * val);
        currMin = Math.min(val, currMin * val);

        if(currMax > maxRef[0]) maxRef[0] = currMax;

        return solve(nums, index + 1, maxRef, currMax, currMin);
    }
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int[] maxRef = new int[1];
        maxRef[0] = nums[0];
        solve(nums, 1, maxRef, nums[0], nums[0]);
        return maxRef[0];
    }
}