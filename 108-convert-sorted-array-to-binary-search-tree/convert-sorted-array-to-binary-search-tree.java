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
    public TreeNode BuildBST(int[] nums, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = BuildBST(nums, start, mid - 1);
        root.right = BuildBST(nums, mid + 1, end);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildBST(nums, 0, nums.length - 1);
    }
}