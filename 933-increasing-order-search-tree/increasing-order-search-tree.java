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
    TreeNode prev = null;
    TreeNode newRoot = null;

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        
        if(newRoot == null){
            newRoot = root;
        }
        else{
            prev.right = root;
        }
        
        root.left = null;
        prev = root;

        inOrder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return newRoot;
    }
}