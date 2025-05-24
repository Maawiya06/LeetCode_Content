class Solution {
    public int calculate(String s) {
        return evaluate(s.toCharArray(), new int[]{0});
    }

    private int evaluate(char[] chars, int[] index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while (index[0] < chars.length) {
            char ch = chars[index[0]];

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '(') {
                index[0]++; // skip '('
                num = evaluate(chars, index); // recursively evaluate the expression in parentheses
            }

            // Check for operator or end of expression
            if ((!Character.isDigit(ch) && ch != ' ' && ch != '(') || index[0] == chars.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }
                sign = ch;
                num = 0;
            }

            if (ch == ')') {
                break; // return control to the outer call
            }

            index[0]++;
        }

        // Sum up the values in the stack
        int sum = 0;
        for (int val : stack) {
            sum += val;
        }

        return sum;
    }
}
