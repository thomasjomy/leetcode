package my.test.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String input1 = "abcabcbb";
        String input2 = "pwwkew";
        String input3 = "bbbbb";

        System.out.println(longestSubstring(input1));

    }

    private static String longestSubstring(String input) {
        char[] inputArr = input.toCharArray();

        int lowerBound = 0;
        int upperBound = 1;
        String substring = null;
        int maxSubStrinLen = 0;
        Map<Character, Integer> memory = new HashMap<>();

        while (lowerBound < upperBound && upperBound < input.length()) {
            System.out.println("lowerBound : " + lowerBound + " upperBound: " + upperBound + " memory: " + memory);
            memory.put(inputArr[lowerBound], lowerBound);

            while (upperBound < input.length()) {
                if (!memory.containsKey(inputArr[upperBound])) {
                    memory.put(inputArr[upperBound], upperBound);
                    upperBound++;
                } else {
                    break;
                }
            }

            int currentUpperBound = upperBound >= input.length() ? input.length() - 1: upperBound;
            System.out.println("lowerBound : " + lowerBound + " upperBound: " + currentUpperBound + " memory: " + memory);
            int subStringLen = currentUpperBound - lowerBound;
            if (subStringLen > maxSubStrinLen) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = lowerBound; i < currentUpperBound; i++) {
                    stringBuilder.append(inputArr[i]);
                }
                substring = stringBuilder.toString();
                maxSubStrinLen = subStringLen;
                System.out.println("answer: " + substring + " len: " + subStringLen);
            }

            if (upperBound < input.length()){
                int newLowerBound = memory.get(inputArr[upperBound]) + 1;
                for (int i = lowerBound; i < newLowerBound; i++) {
                    memory.remove(inputArr[i]);
                }
                lowerBound = newLowerBound;
                if (upperBound <= lowerBound) {
                    upperBound = lowerBound + 1;
                }
            }

        }

        return substring;
    }
}
