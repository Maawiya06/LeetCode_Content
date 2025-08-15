class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try all possible substring lengths
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) { 
                boolean match = true;

                // Compare characters in repeating blocks
                for (int i = len; i < n; i++) {
                    if (s.charAt(i) != s.charAt(i - len)) {
                        match = false;
                        break;
                    }
                }

                if (match) return true;
            }
        }

        return false;
    }
}
