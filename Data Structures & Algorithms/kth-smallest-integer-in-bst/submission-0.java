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
    public int cachedValue = -1;
    public int finalAns = -1;
    public int count = 0;
    public void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count += 1;
        cachedValue = root.val;
        if (k == count) {
            finalAns = root.val;
            return;
        }
        inorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return finalAns != -1 ? finalAns : cachedValue;
    }
}
