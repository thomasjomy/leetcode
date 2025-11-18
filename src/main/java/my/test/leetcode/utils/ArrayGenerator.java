package my.test.leetcode.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGenerator {
    public static List<Integer> generate(int size, int upperBound) {
        List<Integer> result = new ArrayList<Integer>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomInt = random.nextInt(upperBound);
            result.add(randomInt);
        }

        return result;
    }
}
