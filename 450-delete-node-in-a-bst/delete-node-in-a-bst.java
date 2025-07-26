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

    public TreeNode maxvalue(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        
        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
             return root;
        }
        
        if(root.val == key){
            
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null && root.right != null){
                TreeNode childsubTree = root.right;
                return childsubTree;
            }
            else if(root.left != null && root.right == null){
                TreeNode childsubTree = root.left;
                return childsubTree;
            }
            else{
                TreeNode maxi = maxvalue(root.left);
                root.val = maxi.val;
                root.left = deleteNode(root.left, maxi.val);
            }
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
}