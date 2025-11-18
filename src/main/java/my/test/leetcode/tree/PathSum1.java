package my.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList();
        if (root == null) {
            return allPaths;
        }
        dfs(root, new ArrayList(), allPaths, sum);
        return allPaths;
    }

    private void dfs(TreeNode root, List<Integer> path, List<List<Integer>> allPaths, int sum) {
        path.add(root.value);
        if (root.left != null) {
            dfs(root.left, path, allPaths, sum - root.value);
        }
        if (root.right != null) {
            dfs(root.right, path, allPaths, sum - root.value);
        }
        if (root.left == null && root.right == null) {
            /*Check if sum equals root.val, not sum equals zero!*/
            if (sum == root.value) {
                allPaths.add(new ArrayList(path));
            }
        }
        path.remove(path.size() - 1);
    }
}
