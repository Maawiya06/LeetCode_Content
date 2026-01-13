class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // Edge case: single digit
        if (len == 1) {
            return String.valueOf(num - 1);
        }

        Set<Long> candidates = new HashSet<>();

        // Special boundary palindromes
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        // Get prefix
        int halfLen = (len + 1) / 2;
        long prefix = Long.parseLong(n.substring(0, halfLen));

        // Generate palindromes from prefix, prefix-1, prefix+1
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            String left = String.valueOf(i);
            String right;

            if (len % 2 == 0) {
                right = new StringBuilder(left).reverse().toString();
            } else {
                right = new StringBuilder(left.substring(0, left.length() - 1))
                        .reverse().toString();
            }

            candidates.add(Long.parseLong(left + right));
        }

        long closest = -1;
        for (long cand : candidates) {
            if (cand == num) continue;

            if (closest == -1 ||
                Math.abs(cand - num) < Math.abs(closest - num) ||
                (Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}
