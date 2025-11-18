package my.test.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class MaxPathSumOptimized {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);
        return max;
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int left = Math.max(0, dfs(root.left, map));
        int right = Math.max(0, dfs(root.right, map));
        max = Math.max(max, root.value + left + right);
        int pathSum = root.value + Math.max(left, right);
        map.put(root, pathSum);
        return pathSum;
    }

}
