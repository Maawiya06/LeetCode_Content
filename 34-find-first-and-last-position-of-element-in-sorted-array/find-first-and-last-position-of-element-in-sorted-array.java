class Solution {
    public int firstTime(int[] nums, int target){
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int first = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;

            if(nums[mid] == target){
                first = mid;
                e = mid - 1;
            }
            else if(target > nums[mid]){
                s = mid + 1;
            }
            else{ 
                e = mid - 1;
            }
        }
        return first;
    }

    public int lastTime(int[] nums, int target){
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int last = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(nums[mid] == target){
                last = mid;
                s = mid + 1;
            }
            else if(target > nums[mid]){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstTime(nums, target);
        ans[1] = lastTime(nums, target);
        return ans;
    }
}