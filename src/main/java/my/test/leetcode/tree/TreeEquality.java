package my.test.leetcode.tree;

public class TreeEquality {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
