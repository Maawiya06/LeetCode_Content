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
    public void printrightView(TreeNode root, int level, ArrayList<Integer> rightview){
        if(root == null){
            return;
        }

        if(level == rightview.size()){
            rightview.add(root.val);
        }

        printrightView(root.right, level + 1, rightview);
        printrightView(root.left, level + 1, rightview);
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rightview = new ArrayList<>();
        printrightView(root, 0, rightview);
        return rightview;
    }
}