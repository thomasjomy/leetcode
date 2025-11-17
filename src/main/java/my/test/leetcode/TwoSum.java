package my.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(sumOfTwoNumbers(nums, target)));
    }

    private static int[] sumOfTwoNumbers(int[] numbers, int target){
        HashSet<Integer> memory = new HashSet<>();

        for(int i = 0 ; i < numbers.length ; i++){
            int currentNumber = numbers[i];
            int numberNeeded = target - currentNumber;
            boolean found = memory.contains(numberNeeded);
            if(found){
                return new int[] {currentNumber, numberNeeded};
            }
            memory.add(currentNumber);
        }

        return new int[] {};
    }


}
