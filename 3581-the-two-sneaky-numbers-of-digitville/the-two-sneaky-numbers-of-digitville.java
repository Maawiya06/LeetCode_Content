class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> ans = new HashMap<>();
        List<Integer> dup = new ArrayList<>();

        for(int num : nums){
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }

        for(int num : ans.keySet()){
            if(ans.get(num) > 1){
                dup.add(num);
            }
        }

        int[] result = new int[dup.size()];
        for(int i = 0; i < dup.size(); i++){
            result[i] = dup.get(i);
        }

        return result;
    }
}