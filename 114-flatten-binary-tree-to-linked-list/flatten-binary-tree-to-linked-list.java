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
    public void preordertraversal(TreeNode root, List<Integer> result){
        if(root == null) return;

        result.add(root.val);
        preordertraversal(root.left, result);
        preordertraversal(root.right, result);

    }
    public void flatten(TreeNode root) {
        if(root == null) return;

        List<Integer> ans = new ArrayList<>();
        preordertraversal(root, ans);

        // rebuilt the tree
        TreeNode curr = root;
        for(int i = 1; i < ans.size(); i++){
            curr.left = null;
            curr.right = new TreeNode(ans.get(i));
            curr = curr.right;
        }
    }
}