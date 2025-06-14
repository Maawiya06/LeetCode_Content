import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i); // Java doesn't allow for-each on String directly this way
            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        // Remove remaining k digits from the end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the result from stack
        for (char ch : st) {
            ans.append(ch);
        }

        // Remove leading zeros
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
