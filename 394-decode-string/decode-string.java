class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                String stringToRepeat = "";
                while (!st.isEmpty() && !st.peek().equals("[") && !Character.isDigit(st.peek().charAt(0))) {
                    String peek = st.pop();
                    stringToRepeat = peek + stringToRepeat;
                }

                if (!st.isEmpty() && st.peek().equals("[")) {
                    st.pop(); // remove the '['
                }

                String numericTime = "";
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    numericTime = st.pop() + numericTime;
                }

                int n = 0;
                if (!numericTime.isEmpty()) {
                    n = Integer.parseInt(numericTime);
                }

                String currDecode = "";
                while (n-- > 0) {
                    currDecode += stringToRepeat;
                }
                st.push(currDecode);
            } else {
                st.push(String.valueOf(ch));
            }
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
