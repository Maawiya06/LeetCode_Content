class Solution {
    private boolean isBalanced(int[] freq){
        int count = 0;
        for(int F : freq){
            if(F > 0){
                if(count == 0) count = F;
                else if (count != F) return false;
            }
        }
        return count != 0;
    }
    public int longestBalanced(String s) {
        String ans = s;

        int n = ans.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for(int j = i; j < n; j++){
                freq[ans.charAt(j) - 'a']++;

                if(isBalanced(freq)){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}