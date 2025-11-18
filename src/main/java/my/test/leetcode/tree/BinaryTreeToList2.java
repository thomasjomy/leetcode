package my.test.leetcode.tree;


/*
 * Credit: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solution/
 */
public class BinaryTreeToList2 {

    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode curr) {
        if (curr == null) {
            return null;
        }
        if (curr.left == null && curr.right == null) {
            return curr;
        }
        TreeNode leftTail = flat(curr.left);
        TreeNode rightTail = flat(curr.right);
        if (leftTail != null) {
            leftTail.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }
}
