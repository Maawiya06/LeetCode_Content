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
    int postIndex = 0;

    public int searchInorder(int[] inorder, int target, int size){
        for(int i = 0; i < size; i++){
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[]postorder, int[] inorder, int inOrderStart, int inOrderEnd, int size){
        // base case
        if(postIndex < 0 || inOrderStart > inOrderEnd){
            return null;
        }

        int element = postorder[postIndex--];

        TreeNode root = new TreeNode(element);

        int position = searchInorder(inorder, element, size);

        root.right = helper(postorder, inorder, position + 1, inOrderEnd, size);
        root.left = helper(postorder, inorder, inOrderStart, position - 1,  size);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        postIndex = size - 1;
        return helper(postorder, inorder, 0, size - 1, size);
    }
}