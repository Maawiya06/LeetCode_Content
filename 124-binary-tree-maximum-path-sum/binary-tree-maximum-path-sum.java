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
    private int maxsum = Integer.MIN_VALUE;

    private int findmaxPath(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, findmaxPath(root.left));
        int right = Math.max(0, findmaxPath(root.right));

        maxsum = Math.max(maxsum, left + root.val + right);

        return root.val + Math.max(left , right);
    }
    public int maxPathSum(TreeNode root) {
        findmaxPath(root);
        return maxsum;
    }
}