class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int left = 2;
        int right = 2;
        while(right < nums.length){
            if(nums[right] != nums[left - 2]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}