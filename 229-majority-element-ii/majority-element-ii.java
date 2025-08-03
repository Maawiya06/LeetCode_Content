class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candicate2 = null;

        for(int num : nums){
            if(candidate1 != null && num == candidate1){
                count1++;
            }
            else if(candicate2 != null && num == candicate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candicate2= num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        // count frequesncy
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == candidate1) count1++;
             else if (num == candicate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candicate2);

        return result;
    }
}