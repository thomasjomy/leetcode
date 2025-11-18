package my.test.leetcode.tree;

public class BalanceCheck {
    public boolean isBalanced(TreeNode root) {
        return getH(root) != -1;
    }

    private int getH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getH(root.left);
        if (leftH == -1) {
            return -1;
        }
        int rightH = getH(root.right);
        if (rightH == -1) {
            return -1;
        }
        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
}
