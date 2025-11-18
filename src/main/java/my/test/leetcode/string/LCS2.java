package my.test.leetcode.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//Leetcode 128
public class LCS2 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }
        int max = 1;

        for (int num : nums) {
            if (set.remove(num)) {
                int val = num;
                int count = 1;
                while (set.remove(val - 1)) {
                    val--; // we find all numbers that are smaller than num and remove them from
                    // the set
                }
                count += num - val;

                val = num;
                while (set.remove(val + 1)) {
                    val++; // then we find all numbers that are bigger than num and also remove
                    // them from the set
                }
                count += val - num;

                max = Math.max(max, count);
            }
        }
        return max;
    }

    /*
     * O(n) time complexity.
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            // we'll go through this set instead of nums, this makes a big difference in time
            // complexity, esp. based on LeetCode test cases
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    /*
     * O(nlogn) time complexity
     */
    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums) {
            treeSet.add(i); // O(logn) time complexity for each add() call
        }
        int ans = 1;
        Iterator<Integer> it = treeSet.iterator();
        Integer curr = it.next();
        int len = 1;
        while (it.hasNext()) {
            Integer next = it.next();
            if (curr + 1 == next) {
                len++;
            } else {
                len = 1;
            }
            curr = next;
            ans = Math.max(ans, len);
        }
        ans = Math.max(ans, len);
        return ans;
    }
}
