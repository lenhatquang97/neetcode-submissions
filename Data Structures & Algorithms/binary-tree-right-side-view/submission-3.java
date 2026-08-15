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
        public int level;
        public Pair(TreeNode tr, int lv) {
            node = tr;
            level = lv;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        Pair lastValue = null;
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            if (tmp.node != null) {
                if (lastValue != null && lastValue.node != null && tmp.level != lastValue.level) {
                    res.add(lastValue.node.val);
                    lastValue = tmp;
                } else {
                    lastValue = tmp;
                }

                if (tmp.node.left != null) {
                    q.add(new Pair(tmp.node.left, tmp.level + 1));
                }
                if (tmp.node.right != null) {
                    q.add(new Pair(tmp.node.right, tmp.level + 1));
                }
            } 
        }

        if (lastValue != null && lastValue.node != null) {
            res.add(lastValue.node.val);
        }
        return res;
    }
}
