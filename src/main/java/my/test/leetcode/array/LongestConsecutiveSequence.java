package my.test.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Medium
 *
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] test1 = {2, 20, 4, 10, 3, 4, 5};
        int[] test2 = {0, 3, 2, 5, 4, 6, 1, 1};

        int seqLen1 = longestConsecutive(test1);
        int seqLen2 = longestConsecutive(test2);

        System.out.println("Array: " + Arrays.toString(test1) + " seqLen = " + seqLen1);
        System.out.println("Array: " + Arrays.toString(test2) + " seqLen = " + seqLen2);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> memory = new HashSet<>();

        for (int currentNum : nums) {
            memory.add(currentNum);
        }

        int maxConsecutiveSeqLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int consecutiveSeqLen = 1;

            if (!memory.contains(currentNumber - 1)) {
                while (memory.contains(currentNumber + 1)) {
                    currentNumber = currentNumber + 1;
                    consecutiveSeqLen = consecutiveSeqLen + 1;
                }

                maxConsecutiveSeqLen = Math.max(consecutiveSeqLen, maxConsecutiveSeqLen);
            }
        }

        return maxConsecutiveSeqLen;

    }
}
