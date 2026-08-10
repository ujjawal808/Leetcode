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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        int height = height(root);

        for (int level = 1; level <= height; level++) {

            List<Integer> currentLevel = new ArrayList<>();

            getLevel(root, level, currentLevel);

            ans.add(currentLevel);
        }

        return ans;
    }

    // Find height of tree
    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //  klevel()
    public void getLevel(TreeNode root, int level,
                         List<Integer> currentLevel) {

        if (root == null) {
            return;
        }

        if (level == 1) {
            currentLevel.add(root.val);
            return;
        }

        getLevel(root.left, level - 1, currentLevel);
        getLevel(root.right, level - 1, currentLevel);
    }
}