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
    int solve(TreeNode root, Map<TreeNode, Integer> dp){
        if(root == null) return 0;
        
        if(dp.containsKey(root)) return dp.get(root);

        int robberHouse = 0;
        int dontRobberHouse = 0;

        // include
        robberHouse = robberHouse + root.val;
        if(root.left != null){
            robberHouse = robberHouse + solve(root.left.left, dp) + solve(root.left.right, dp);
        }
        if(root.right != null){
            robberHouse = robberHouse + solve(root.right.left, dp) + solve(root.right.right, dp);
        }

        // exclude
        dontRobberHouse = solve(root.left, dp) + solve(root.right, dp);

        dp.put(root, Math.max(robberHouse, dontRobberHouse));
        return dp.get(root);

    }
    
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap<>();
        
        return solve(root, dp);
    }
}