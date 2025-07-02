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
    int preIndex = 0; 

    public int searchInorder(int[] inorder, int target, int size) {
        for (int i = 0; i < size; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode helperFunction(int[] preorder, int[] inorder, int inOrderStart, int inOrderEnd, int size) {
        // Base case
        if (preIndex >= size || inOrderStart > inOrderEnd) {
            return null;
        }

        // Solve one case
        int element = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(element);  

        // Find element in inorder
        int position = searchInorder(inorder, element, size); 

        // Recursive calls
        root.left = helperFunction(preorder, inorder, inOrderStart, position - 1, size);
        root.right = helperFunction(preorder, inorder, position + 1, inOrderEnd, size);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        return helperFunction(preorder, inorder, 0, size - 1, size);
    }
}