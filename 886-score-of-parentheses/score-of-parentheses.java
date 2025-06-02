class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Base score

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0); 
            } else {
                int top = stack.pop();
                int value = top == 0 ? 1 : 2 * top;
                stack.push(stack.pop() + value);
            }
        }

        return stack.pop();
    }
}
