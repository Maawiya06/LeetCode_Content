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

    int pathFromOneRoot(TreeNode root, long sum) {
        if (root == null) return 0;

        int res = 0;
        if (sum == root.val) {
            res++;
        }

        res += pathFromOneRoot(root.left, sum - root.val);
        res += pathFromOneRoot(root.right, sum - root.val);

        return res;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return pathFromOneRoot(root, targetSum)
               + pathSum(root.left, targetSum)
               + pathSum(root.right, targetSum);
    }

}
