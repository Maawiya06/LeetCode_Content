/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // base case
        if(root == null){
            return null;
        }

        // both p and q comes in left subtree of root node
        if(p.val < root.val && q.val < root.val){
            TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
            return leftAns;
        }

        if(p.val > root.val && q.val > root.val){
            TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
            return rightAns;
        }

        // // if p in left subtrr of root node and q in the right subtrr 
        // if(p.val < root.val && q.val > root.val){
        //     return root;
        // }

        // // if q in left subtrr of root node and p in the right subtrr 
        // if(p.val > root.val && q.val < root.val){
        //     return root;
        // }

        return root;
    }
}