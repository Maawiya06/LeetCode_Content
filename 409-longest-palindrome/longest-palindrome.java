class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[128];

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        int length = 0;
        boolean oddfound = false;

        for(int count : freq){
            length += (count/2) * 2;
            if(count % 2 == 1){
                oddfound = true;
            }
        }

        if(oddfound){
            length += 1;
        }

        return length;
    }
}