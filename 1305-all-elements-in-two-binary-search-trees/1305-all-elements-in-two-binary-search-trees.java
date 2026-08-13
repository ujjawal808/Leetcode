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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Step 1: Inorder traversal of both BSTs
        inorder(root1, list1);
        inorder(root2, list2);

        // Step 2: Merge two sorted lists
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {

            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        // Remaining elements from list1
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        // Remaining elements from list2
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }

        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}