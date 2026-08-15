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
        public class Pair {
        public TreeNode node;
        public int maxValue;
        public Pair(TreeNode tn, int mx) {
            node = tn;
            maxValue = mx;
        }
    }
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.val));
        int count = 0;
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            if (tmp.maxValue <= tmp.node.val) {
                count++;
            }

            if (tmp.node != null && tmp.node.left != null) {
                q.add(new Pair(tmp.node.left, Math.max(tmp.maxValue, tmp.node.left.val)));
            }
            if (tmp.node != null && tmp.node.right != null) {
                q.add(new Pair(tmp.node.right, Math.max(tmp.maxValue, tmp.node.right.val)));
            }
        }

        return count;   
    }
}
