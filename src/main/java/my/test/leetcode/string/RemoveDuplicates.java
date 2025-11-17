package my.test.leetcode.string;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remoteDuplicates("aba"));
        System.out.println(remoteDuplicates("aaa"));
        //System.out.println(remoteDuplicates("abcd"));
    }

    public static String remoteDuplicates(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return inputString;
        }

        int stringLength = inputString.length();

        if (stringLength < 2) {
            return inputString;
        }

        char[] input = inputString.toCharArray();

        int tail = 1;
        for (int i = 1; i < stringLength; i++) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (input[i] == input[j]) break;
            }

            if (j == tail) {
                input[tail] = input[i];
                ++tail;
            }
        }

        //input[tail] = 0;

        return new String(input);
    }
}
