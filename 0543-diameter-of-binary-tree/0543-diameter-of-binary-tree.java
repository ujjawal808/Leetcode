class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }
}