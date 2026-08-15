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
    public boolean isValidBSTCustom(int left, int right, TreeNode root) {
        if (root == null) return true;
        if (root.val > left && root.val < right) {
            return isValidBSTCustom(left, root.val, root.left) && isValidBSTCustom(root.val, right, root.right);
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTCustom(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
}
