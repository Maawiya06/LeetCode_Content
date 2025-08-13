class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // int n = nums.length;

        // for(int i = 0; i < n; i++){
        //     int sum = nums[i];
        //     for(int j = i + 1; j < n; j++){
        //         sum += nums[j];
        //         if(k == 0){
        //             if(sum == 0) return true;
        //         }
        //         else{
        //             if(sum % k == 0) return true;
        //         }
        //     }
        // }

        // return false;


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder 0 at index -1 for edge case
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}