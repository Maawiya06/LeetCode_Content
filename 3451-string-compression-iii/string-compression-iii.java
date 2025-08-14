class Solution {
    public String compressedString(String word) {
        
        String ans = "";
        int count = 1;

        for(int i = 0; i < word.length(); i++){
            if(i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1)){
                count++;
                if(count == 10){
                    ans += "9" + word.charAt(i);
                    count = 1;
                }
            }
            else{
                ans += count + "" + word.charAt(i);
                count = 1;
                
            }
        }
        return ans;
    }
}