class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) { 
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        
        StringBuilder ans = new StringBuilder(); 
        while (!st.isEmpty()) {
            ans.append(st.pop()); 
        }

        ans.reverse(); 
        return ans.toString(); 
    }
}
