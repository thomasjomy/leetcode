package my.test.leetcode.tree;

import java.util.*;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> levels = new ArrayList();
        if (root == null) {
            return levels;
        }
        queue.offer(root);
        boolean forward = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.value);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (!forward) {
                Collections.reverse(level);
            }
            forward = !forward;
            levels.add(level);
        }
        return levels;
    }
}
