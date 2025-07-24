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
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> subTreeMap = new HashMap<>();

    // Helper function for preorder traversal and serialization
    String preorder(TreeNode root) {
        if (root == null) return "N";

        String curr = String.valueOf(root.val);
        String left = preorder(root.left);
        String right = preorder(root.right);
        String serial = curr + "," + left + "," + right;

        subTreeMap.put(serial, subTreeMap.getOrDefault(serial, 0) + 1);
        if (subTreeMap.get(serial) == 2) {
            ans.add(root); // Only add when seen second time
        }

        return serial;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        return ans;
    }
}
