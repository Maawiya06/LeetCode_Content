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
    public void helper(TreeNode node, String path, List<String> ans){
        if(node == null) return;

        // Build path string
        if(node.left == null && node.right == null){
            ans.add(path + node.val);  
        } else {
            path += node.val + "->";   
            helper(node.left, path, ans);
            helper(node.right, path, ans);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root != null){
            helper(root, "", ans);
        }
        return ans;
    }
}
