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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        int option1 = diameterOfBinaryTree(root.left);
        int option2 = diameterOfBinaryTree(root.right);
        int option3 = height(root.left) + height(root.right);
        int diameter = Math.max(option1, Math.max(option2, option3));
        return diameter;
    }
}