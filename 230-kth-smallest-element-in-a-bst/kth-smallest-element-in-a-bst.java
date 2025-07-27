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
    int k;  
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftAns = helper(root.left);
        if (leftAns != -1) {
            return leftAns;
        }

        this.k--;
        if (this.k == 0) {
            return root.val;
        }

        int rightAns = helper(root.right);
        if (rightAns != -1) {
            return rightAns;
        }

        return -1;  
    }
}
