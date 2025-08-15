class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] freTable = new int[256];

        for(int i = 0; i < s.length(); i++){
            freTable[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++){
            freTable[t.charAt(i)]--;
        }

        for(int i = 0; i < 256; i++){
            if(freTable[i] != 0){
                return false;
            }
        }

        return true;
    }
}