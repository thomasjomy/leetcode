package my.test.leetcode.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        return left.value == right.value
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
