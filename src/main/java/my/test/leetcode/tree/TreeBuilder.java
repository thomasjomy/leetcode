package my.test.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBuilder {

    public static TreeNode constructBinaryTree(List<Integer> treeValues) {
        TreeNode root = new TreeNode(treeValues.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < treeValues.size(); i++) {
            TreeNode current = queue.poll();
            if (treeValues.get(i) != null) {
                current.left = new TreeNode(treeValues.get(i));
                queue.offer(current.left);
            }
            if (++i < treeValues.size() && treeValues.get(i) != null) {
                current.right = new TreeNode(treeValues.get(i));
                queue.offer(current.right);
            }
        }
        return root;
    }
}
