class Solution {

    private static char[] ALLOWED_LETTERS = { 'a', 'b', 'c' };

    private int happyStringCount;
    private String kthHappyString;

    public String getHappyString(int n, int k) {
        this.happyStringCount = 0;
        this.kthHappyString = "";
        kthHappyStringHelper(new StringBuilder(), n, k);
        return happyStringCount >= k ? kthHappyString : "";
    }

    private void kthHappyStringHelper(StringBuilder currStr, int n, int k) {

        int currStrSize = currStr.length();

        if (currStrSize == n) {
            happyStringCount++;
            if (happyStringCount == k) {
                kthHappyString = currStr.toString();
            }
            return;
        }

        for (char c : ALLOWED_LETTERS) {

            if (currStrSize > 0 && c == currStr.charAt(currStrSize - 1))
                continue;

            currStr.append(c);
            kthHappyStringHelper(currStr, n, k);
            currStr.deleteCharAt(currStrSize);

            if (happyStringCount == k)
                return;
        }
    }
}