import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> freqs = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) freqs.add(f);
        }

        Collections.sort(freqs);
        int maxFreq = freqs.get(freqs.size() - 1);
        int minDeletions = Integer.MAX_VALUE;

        for (int target = 1; target <= maxFreq; target++) {
            int deletions = 0;
            for (int f : freqs) {
                if (f < target) {
                    deletions += f;
                } else if (f > target + k) {
                    deletions += f - (target + k);
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
