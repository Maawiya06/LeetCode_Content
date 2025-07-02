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
    public boolean solve(TreeNode root, int targetSum, int sum){
        // base case
        if(root == null){
            return false;
        }

        sum = sum + root.val;
        if(root.left == null && root.right == null){
            // currently standing on leaf node
            
            // verify
            if(sum == targetSum){
                return true;
            }
            else{
                return false;
            }
        }

        boolean leftAns = solve(root.left, targetSum, sum);
        boolean rightAns = solve(root.right, targetSum, sum);
        return leftAns || rightAns;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        boolean ans = solve(root, targetSum, sum);
        return ans;
    }
}