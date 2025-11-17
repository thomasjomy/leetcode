package my.test.leetcode;

import java.util.Arrays;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] sample1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] sample2 = {3, 3};
        int target2 = 6;

        int[] sample3 = {3, 1, 7, 9, 2, 4};
        int target3 = 6;

        int[] result1 = findResult(sample1, target1);
        System.out.printf("result1 : " + Arrays.toString(result1));

        int[] result2 = findResult(sample2, target2);
        System.out.printf("result1 : " + Arrays.toString(result2));

        int[] result3 = findResult(sample3, target3);
        System.out.printf("result1 : " + Arrays.toString(result3));


    }

    private static int[] findResult(int[] numbers, int targetSum) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int first = numbers[i];
                int second = numbers[j];

                int sum = first + second;

                if (sum == targetSum) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
