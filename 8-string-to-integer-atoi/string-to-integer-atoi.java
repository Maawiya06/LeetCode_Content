class Solution {
    public int myAtoi(String s) {
        
        int num = 0, i = 0, sign = 1;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }

        // Read digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 || 
               (num == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }

        return num * sign;
    }
}
