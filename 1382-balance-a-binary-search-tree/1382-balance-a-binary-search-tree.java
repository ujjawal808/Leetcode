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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // Step 1: BST -> Sorted List
        inorder(root, list);

        // Step 2: Sorted List -> Balanced BST
        return createBST(list, 0, list.size() - 1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public TreeNode createBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = createBST(list, start, mid - 1);
        root.right = createBST(list, mid + 1, end);

        return root;
    }
}