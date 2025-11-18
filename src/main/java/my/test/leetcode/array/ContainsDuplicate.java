package my.test.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy
 * <p>
 * Solution : Sorting, Hashset
 */
public class ContainsDuplicate {
    
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] test2 = {5, 7, 8, 9, 1, 2, 4, 7};

        System.out.println(containsDuplicate(test1));
        System.out.println(containsDuplicate(test2));
    }

    private static boolean containsDuplicate(int[] numbers) {
        Set<Integer> memory = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {

            int currentNum = numbers[i];

            if (memory.contains(currentNum)) {
                return true;
            } else {
                memory.add(currentNum);
            }
        }

        return false;
    }
}
