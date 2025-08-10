class Solution {
    public boolean isPalindrome(String s) {
        
    StringBuilder cleaned = new StringBuilder();
    for (char c : s.toLowerCase().toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            cleaned.append(c);
        }
    }

    // Two-pointer check
    int i = 0, j = cleaned.length() - 1;
    while (i < j) {
        if (cleaned.charAt(i) != cleaned.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }

    return true;
}

}