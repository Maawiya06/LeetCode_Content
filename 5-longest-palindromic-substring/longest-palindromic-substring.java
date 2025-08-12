class Solution {
    Boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
         return true;
    }
    public String longestPalindrome(String s) {
        
         String ans = "";
         for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(s, i, j)){
                    String t = s.substring(i, j + 1);
                    ans = t.length() > ans.length() ? t : ans;
                }
            }
         }

         return ans;
    }
}