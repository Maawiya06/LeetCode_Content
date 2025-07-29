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
    void inorder(TreeNode root, List<Integer> ans){
        if(root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    TreeNode buildTree(List<Integer> ans, int s , int e){
        if(s > e) return null;

        int mid = (s + e) / 2;

        TreeNode root = new TreeNode(ans.get(mid));
        root.left = buildTree(ans, s, mid - 1);
        root.right = buildTree(ans, mid + 1, e);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);

        //build balanced BST using inorder traversal
        return buildTree(ans, 0, ans.size() - 1);
    }
}