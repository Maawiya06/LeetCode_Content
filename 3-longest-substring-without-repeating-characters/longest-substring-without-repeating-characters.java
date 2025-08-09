class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Stack<Character> st = new Stack<>();
        int maxLen = 0;
        

        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);

            if(st.contains(c)){
                while(!st.isEmpty() && st.contains(c)){
                    st.remove(0);
                }
            }

            st.push(c);
            maxLen = Math.max(maxLen, st.size());
        }

        return maxLen;
    }
}