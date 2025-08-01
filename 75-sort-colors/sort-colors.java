class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {

        int n = nums.length;
        int index = 0;
        int left = 0;
        int right = n - 1;

        while(index <= right){
            if(nums[index] == 0){
                swap(nums, index, left);
                left++;
                index++;
            }
            else if(nums[index] == 2){
                swap(nums, index, right);
                right--;
            }
            else{
                index++;
            }
        }
    }
}