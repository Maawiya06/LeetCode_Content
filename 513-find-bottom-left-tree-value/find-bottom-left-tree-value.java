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
    private int maxdepth = -1;
    private int leftmostView = 0;

    public void dfs(TreeNode node, int depth){
        if(node == null) return ;

        if(depth > maxdepth){
            maxdepth = depth;
            leftmostView = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftmostView;
    }
}