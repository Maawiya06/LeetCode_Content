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
    public List<TreeNode> solve(int start, int end){
        //base case
        List<TreeNode> ans = new ArrayList<>();

        if(start > end) {
            ans.add(null);
            return ans;
        }
        if(start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> left = solve(start, i - 1);
            List<TreeNode> right = solve(i + 1, end);

            for(int j = 0; j < left.size(); j++){
                for(int k = 0; k < right.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            List<TreeNode> ans = new ArrayList<>();
            ans.add(null);
            return ans;
        }
        return solve(1, n);
    }
}