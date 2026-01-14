class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        String a = s.trim();
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == ' '){
                length = 0;
            }
            else{
                length++;
            }
        }
        return length;
    }
}