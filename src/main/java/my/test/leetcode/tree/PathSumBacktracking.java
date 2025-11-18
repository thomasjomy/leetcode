package my.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumBacktracking {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(root, new ArrayList<>(), targetSum, 0, ans);
        return ans;
    }

    private void backtracking(
            TreeNode root,
            List<Integer> path,
            int targetSum,
            int currentSum,
            List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        path.add(root.value);
        currentSum += root.value;
        if (currentSum == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1); // backtracking
            return;
        }
        backtracking(root.left, path, targetSum, currentSum, ans);
        backtracking(root.right, path, targetSum, currentSum, ans);
        path.remove(path.size() - 1); // backtracking
    }
}
