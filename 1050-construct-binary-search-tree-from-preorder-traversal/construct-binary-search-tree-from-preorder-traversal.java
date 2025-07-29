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
    public TreeNode build(int[] i, int min, int max, int[] preorder) {

        if (i[0] >= preorder.length) {
            return null;
        }

        TreeNode root = null;
        if (preorder[i[0]] > min && preorder[i[0]] < max) {
            root = new TreeNode(preorder[i[0]++]); 
            root.left = build(i, min, root.val, preorder);
            root.right = build(i, root.val, max, preorder);
        }

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0};  
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return build(i, min, max, preorder);
    }
}
