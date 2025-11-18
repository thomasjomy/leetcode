package my.test.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                if (curr.left == null && curr.right == null) {
                    return level;
                }
            }
        }
        return level;
    }
}
