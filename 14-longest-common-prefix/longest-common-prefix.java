class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // ✅ prevents ArrayIndexOutOfBounds

        String first = strs[0];
        char[] chars = first.toCharArray();
        StringBuilder prefix = new StringBuilder();

        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }
}
