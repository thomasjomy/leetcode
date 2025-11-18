package my.test.leetcode.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return dfs(num, 0, num.length - 1);
    }

    public TreeNode dfs(int[] num, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = dfs(num, left, mid - 1);
        node.right = dfs(num, mid + 1, right);
        return node;
    }
}

