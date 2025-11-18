package my.test.leetcode.tree;

public class TreeUtils {
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    private static int maxLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeUtils.maxLevel(root.left), TreeUtils.maxLevel(root.right)) + 1;
    }
}
