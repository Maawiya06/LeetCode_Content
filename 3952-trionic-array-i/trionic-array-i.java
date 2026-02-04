class Solution {
    boolean solve(int[] nums, int a, int b){
        if(a == 0 || b == nums.length - 1) return false;
        for(int i = a; i < b; i++){
            if(nums[i] <= nums[i + 1]) return false;
        
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        for(int i = 0; i < n- 1; i++){
            if(start == 0 && nums[n - 1 - i] <= nums[n - 2 - i]) start = n - 1 - i;
            if(end == n - 1 && nums[i] >= nums[i + 1]) end = i;
            if(end < start) return solve(nums, end, start);
        }
        return false;
    }
}