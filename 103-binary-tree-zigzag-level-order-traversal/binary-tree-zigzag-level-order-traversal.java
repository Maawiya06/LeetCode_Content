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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;  // Fixed

        boolean LtoR = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int width = q.size();
            List<Integer> oneLevel = new ArrayList<>(Collections.nCopies(width, 0));  

            for (int i = 0; i < width; i++) {
                TreeNode node = q.poll();  

                int index = LtoR ? i : width - i - 1;
                oneLevel.set(index, node.val); 

                if (node.left != null) {
                    q.add(node.left);  
                }
                if (node.right != null) {
                    q.add(node.right); 
                }
            }

            LtoR = !LtoR;
            ans.add(oneLevel);
        }

        return ans;
    }
}
