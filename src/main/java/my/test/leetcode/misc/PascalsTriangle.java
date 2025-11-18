package my.test.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList(row));
        }
        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            for (int j = row.size() - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (ans.isEmpty()) {
                ans.add(Arrays.asList(1));
            } else {
                List<Integer> prev = ans.get(ans.size() - 1);
                List<Integer> curr = new ArrayList<>(prev.size() + 1);
                curr.add(1);
                for (int j = 0; j < prev.size() - 1; j++) {
                    curr.add(prev.get(j) + prev.get(j + 1));
                }
                curr.add(1);
                ans.add(curr);
            }
        }
        return ans;
    }
}
