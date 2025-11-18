package my.test.leetcode.tree;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.value = x;
    }

    public TreeNode(TreeNode left, int value, TreeNode right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }

}
