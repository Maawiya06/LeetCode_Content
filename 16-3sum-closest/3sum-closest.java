class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        // Arrays.sort(nums);
        // int ans = nums[0] + nums[1] + nums[2];
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         for(int k = j + 1; k < nums.length; k++){
        //             int sum = nums[i] + nums[j] + nums[k];
        //             if(Math.abs(sum - target) < Math.abs(ans - target)){
        //                 ans = sum;
        //             }
        //         }
        //     }
        // }
        // return ans;

        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int maxDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if(diff < maxDiff){
                    maxDiff = diff;
                    ans = sum;
                }
                if(sum == target){
                    return sum;
                }
                else if(sum < target) left++;
                else right--;
            }
        }
        return ans;
    }
}