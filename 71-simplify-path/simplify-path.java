import java.util.Stack;

class Solution {
    public void buildans(Stack<String> st, StringBuilder ans) {
        if (st.isEmpty()) {
            return;
        }
        String minPath = st.peek();
        st.pop();
        buildans(st, ans);
        ans.append(minPath);
    }

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            int start = i;
            int end = i + 1;
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }
            String minPath = path.substring(start, end);
            i = end;

            if (minPath.equals("/") || minPath.equals("/.")) {
                continue;
            }
            if (!minPath.equals("/..")) {
                st.push(minPath);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }

        StringBuilder ans = new StringBuilder(st.isEmpty() ? "/" : "");
        buildans(st, ans);
        return ans.toString();
    }
}
