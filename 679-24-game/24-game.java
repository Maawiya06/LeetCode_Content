class Solution {
    private static final double EPSILON = 1e-6; 
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = (double) cards[i];
        }
        return solve(nums);
    }

    private boolean solve(double[] nums) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs(nums[0] - TARGET) < EPSILON;
        }

        // Try all pairs of numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Create a new array with n-1 elements
                double[] next = new double[n - 1];
                int index = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next[index++] = nums[k];
                    }
                }

                // Try all operations
                for (double num : compute(nums[i], nums[j])) {
                    next[next.length - 1] = num;
                    if (solve(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Return all possible results of applying +, -, *, /
    private double[] compute(double a, double b) {
        return new double[] {
            a + b,
            a - b,
            b - a,
            a * b,
            b != 0 ? a / b : Double.NaN,
            a != 0 ? b / a : Double.NaN
        };
    }
}
