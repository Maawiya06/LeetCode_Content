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
    static class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            map
                .computeIfAbsent(col, x -> new TreeMap<>())
                .computeIfAbsent(row, x -> new PriorityQueue<>())
                .add(node.val);

            if (node.left != null) {
                q.add(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.add(new Tuple(node.right, row + 1, col + 1));
            }
        }

       
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            ans.add(colList);
        }

        return ans;
    }
}
