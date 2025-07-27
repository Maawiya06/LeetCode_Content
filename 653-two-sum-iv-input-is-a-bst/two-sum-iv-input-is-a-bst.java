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
    void storeInorder(TreeNode root, List<Integer> inorder){
        if(root == null) return;

        // LNR
        storeInorder(root.left, inorder);

        inorder.add(root.val);

        storeInorder(root.right, inorder);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root, inorder);

        // using 2 pointer approach
        int start = 0;
        int end = inorder.size() - 1;

        while(start < end){
            int sum = inorder.get(start) + inorder.get(end);

            if(sum == k){
                return true;
            }
            else if(sum > k){
                end--;
            }
            else if (sum < k){
                start++;
            }
        }
        return false;
    }
}