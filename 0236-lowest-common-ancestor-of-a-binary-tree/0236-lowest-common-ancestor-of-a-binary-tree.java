/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null) {
            return null;
        }

        // If root is p or q
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);

        // If left is null, return right
        if (leftlca == null) {
            return rightlca;
        }

        // If right is null, return left
        if (rightlca == null) {
            return leftlca;
        }

        // Both sides have p and q
        return root;
    }
}