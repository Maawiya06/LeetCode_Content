class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1; // +1 or -1
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                // Build the full number (can be more than 1 digit)
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
                continue; // Already moved i inside number parsing
            }

            else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            }

            else if (ch == '(') {
                // Push current result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for inner expression
                result = 0;
                sign = 1;
            }

            else if (ch == ')') {
                // Pop sign first, then previous result
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }

            // Ignore spaces
            i++;
        }

        return result;
    }
}
