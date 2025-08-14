class Solution {
    public int compress(char[] chars) {
        
        String ans = "";
        int count = 1;
        for (int i = 0; i < chars.length; i++) { 
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                ans += chars[i];
                if (count > 1) {
                    ans += Integer.toString(count);
                }
                count = 1;
            }
        }
        
        // write back to chars array
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        
        return ans.length();
    }
}
