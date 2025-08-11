class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        
        // Count frequency of each digit
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        
        StringBuilder left = new StringBuilder();
        int mid = -1;
        
        //Build left half (largest to smallest)
        for (int d = 9; d >= 0; d--) {
            //If odd count, reserve one for middle
            if (count[d] % 2 == 1 && mid == -1) {
                mid = d;
            }
            // Add pairs to left half
            for (int i = 0; i < count[d] / 2; i++) {
                left.append(d);
            }
        }
        
        //Remove leading zeros in left half if possible
        if (left.length() > 0 && left.charAt(0) == '0') {
            left.setLength(0); // All zeros → clear
        }
        
        //If left is empty
        if (left.length() == 0) {
            if (mid != -1) return String.valueOf(mid);
            else return "0"; // only zeros
        }
        
        //Build palindrome
        StringBuilder right = new StringBuilder(left).reverse();
        StringBuilder result = new StringBuilder(left);
        if (mid != -1) result.append(mid);
        result.append(right);
        
        return result.toString();
    }
}
