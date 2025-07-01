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
    int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int height = Math.max(leftheight, rightheight) + 1;
        return height;
    }
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null){
            return true;
        }

        // currNode -> balance
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int absdiff = Math.abs(leftHeight - rightHeight);

        boolean currNodeAns = (absdiff <= 1);

        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        if(currNodeAns && leftAns && rightAns){
            return true;
        }
        else{
            return false;
        }
    }
}