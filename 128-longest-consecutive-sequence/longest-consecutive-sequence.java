class Solution {
    public int longestConsecutive(int[] nums) {
        
        Arrays.sort(nums);

        if(nums.length == 0) return 0;

        int longest = 1;
        int currentlong = 1;

        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]) {
                continue;
            }

            if(nums[i] == nums[i - 1] + 1){
                currentlong++;
            }
            else{
                longest = Math.max(longest, currentlong);
                currentlong = 1;
            }
        }

        return Math.max(longest, currentlong);
    }
}