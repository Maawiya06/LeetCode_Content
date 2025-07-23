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
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
        // Case 1: No left child
        if (curr.left == null) {
            ans.add(curr.val);
            curr = curr.right; // ✅ go to right
        } 
        // Case 2: Has a left child
        else {
            // Find inorder predecessor of curr
            TreeNode pred = curr.left;
            while (pred.right != null && pred.right != curr) {
                pred = pred.right;
            }

            // Make a temporary link (thread) from pred to curr
            if (pred.right == null) {
                pred.right = curr;
                curr = curr.left;
            } 
            // Thread already exists: remove it and visit curr
            else {
                pred.right = null;
                ans.add(curr.val);
                curr = curr.right;
            }
        }
    }

     return ans;






        // List<Integer> result = new ArrayList<>();
        // inorderHelper(root, result);
        // return result;
    }

    // private void inorderHelper(TreeNode node, List<Integer> result) {
    //     if (node == null) return;

    //     inorderHelper(node.left, result);    // Left
    //     result.add(node.val);               // Node
    //     inorderHelper(node.right, result);   // Right
    // }
}