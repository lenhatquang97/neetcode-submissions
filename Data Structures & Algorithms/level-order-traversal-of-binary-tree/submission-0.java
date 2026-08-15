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
        public Pair(TreeNode tn, int lv) {
            node = tn;
            level = lv;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        Pair prevState = null;
        List<Integer> ls = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            if (prevState == null) {
                ls.add(tmp.node.val);
                prevState = tmp;
            } else {
                if (tmp.node != null && tmp.level != prevState.level) {
                    res.add(ls);
                    ls = new ArrayList<>();
                    ls.add(tmp.node.val);
                    prevState = tmp;
                } else if (tmp.node != null && tmp.level == prevState.level) {
                    ls.add(tmp.node.val);
                    prevState = tmp;
                }
            }

            if (tmp.node != null && tmp.node.left != null) {
                q.add(new Pair(tmp.node.left, tmp.level + 1));
            }
            if (tmp.node != null && tmp.node.right != null) {
                q.add(new Pair(tmp.node.right, tmp.level + 1));
            }
        }

        res.add(ls);
        return res;
    }
}
