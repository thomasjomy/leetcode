package my.test.leetcode.twopointers;

import java.util.Arrays;

public class TwoSumOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 22;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (numbers[rightPointer] > target && rightPointer > 0) {
            rightPointer = rightPointer - 1;
        }

        while (leftPointer <= rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];

            if (sum < target) {
                leftPointer = leftPointer + 1;
            } else if (sum > target) {
                rightPointer = rightPointer - 1;
            } else {
                return new int[]{leftPointer + 1, rightPointer + 1};
            }
        }

        return new int[]{};
    }
}
