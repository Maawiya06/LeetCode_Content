class Solution {
    public boolean isValid(String s) {
        if (s.charAt(0) != 'a') return false;

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                st.push(ch);
            } else if (ch == 'b') {
                if (!st.isEmpty() && st.peek() == 'a') {
                    st.push('b');
                } else {
                    return false;
                }
            } else { // ch == 'c'
                if (!st.isEmpty() && st.peek() == 'b') {
                    st.pop(); // pop 'b'
                    if (!st.isEmpty() && st.peek() == 'a') {
                        st.pop(); // pop 'a'
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
