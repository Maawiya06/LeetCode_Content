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
    public void solve(TreeNode root, int targetSum, int sum, List<Integer> temp, List<List<Integer>> ans) {
        // base case
        if (root == null) {
            return;
        }

        sum = sum + root.val;
        temp.add(root.val);

        // extra case
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1); // backtrack before return
            return;
        }

        solve(root.left, targetSum, sum, temp, ans);
        solve(root.right, targetSum, sum, temp, ans);
        temp.remove(temp.size() - 1); // backtrack after both calls
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        solve(root, targetSum, sum, temp, ans);
        return ans;
    }
}
