class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen = 0;

        for(int i = 0; i < n; i++){
            boolean[] even = new boolean[100001];
            boolean[] odd = new boolean[100001];

            int evencount = 0, oddcount = 0;

            for(int j = i; j < nums.length; j++){
                int ans = nums[j];

                if(ans % 2 == 0){
                    if(!even[ans]){
                        even[ans] = true;
                        evencount++;
                    }
                }
                else{
                    if(!odd[ans]){
                        odd[ans] = true;
                        oddcount++;
                    }
                }

                if(evencount == oddcount){
                    int totalLength = j - i + 1;
                    if(totalLength > maxlen) maxlen = totalLength;
                }
            }
        }
        return maxlen;
    }
}