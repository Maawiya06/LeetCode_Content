class Solution {
    private int binarysearch(List<Long> list, double val){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < val){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }

    private void insert(List<Long> list, long val){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < val){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        list.add(left, val);
    }
    public int reversePairs(int[] nums) {
        List<Long> ans = new ArrayList<>();
        int count = 0;
        int n = nums.length;

        for(int i = n - 1; i >= 0; i--){
            int pos = binarysearch(ans, nums[i] / 2.0);
            count = count + pos;

            insert(ans, (long) nums[i]);
        }

        return count;
    }
}