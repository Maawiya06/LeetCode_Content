class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); 
        int n = nums.length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Check if max - min ≤ k
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            if (max - min <= k) {
                result.add(new int[]{a, b, c});
            } else {
                return new int[0][];
            }
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}
