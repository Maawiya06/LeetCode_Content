/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean solve(TreeNode root, long lowerbound, long upperbound) {
        // base case
        if (root == null) {
            return true;
        }

        boolean cond1 = (root.val > lowerbound);
        boolean cond2 = (root.val < upperbound);
        boolean leftAns = solve(root.left, lowerbound, root.val);
        boolean rightAns = solve(root.right, root.val, upperbound);

        if (cond1 && cond2 && leftAns && rightAns) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidBST(TreeNode root) {
        long lowerbound = Long.MIN_VALUE;
        long upperbound = Long.MAX_VALUE;

        boolean ans = solve(root, lowerbound, upperbound);
        return ans;
    }
}
