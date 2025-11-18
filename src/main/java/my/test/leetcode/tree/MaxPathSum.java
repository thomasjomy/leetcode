package my.test.leetcode.tree;

//Leetcode 124

/**
 * Frequently asked in coding inteviews
 *
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        max = Math.max(max, root.value + left + right);

        return root.value + Math.max(left, right);
    }


}
