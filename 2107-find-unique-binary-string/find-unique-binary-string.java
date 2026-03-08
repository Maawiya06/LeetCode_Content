class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // int n = nums.length;
        // int size = (int)Math.pow(2, n);
        // int[] ans = new int[size];
        // for(String num: nums){
        //     int val = Integer.parseInt(num, 2);
        //     ans[val]++;
        // }

        // for(int i = 0; i < size; i++){
        //     if(ans[i] == 0){
        //         String result = Integer.toBinaryString(i);
        //         return "0".repeat(n - result.length()) + result;
        //     }
        // }
        // return "0".repeat(n);

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return ans.toString();
    }
}