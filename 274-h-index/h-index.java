class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int left = 0, right = n;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Count papers with at least mid citations:
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= mid) cnt++;
            }
            if (cnt >= mid) {
                ans = mid; // possible answer, search for bigger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
