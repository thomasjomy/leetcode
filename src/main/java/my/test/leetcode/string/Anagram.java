package my.test.leetcode.string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "abcz";
        String s2 = "cba";

        System.out.println(isAnagram(s1, s2));

    }

    private static boolean isAnagram(String s1, String s2){
            if(s1.length() != s2.length()){
                return false;
            }

            int[] frequencyCounter = new int[26];
            Arrays.fill(frequencyCounter, 0);

            for(char c : s1.toCharArray()){
                frequencyCounter[c - 'a'] =   frequencyCounter[c - 'a'] + 1;
            }

            System.out.println("First iteration: " + Arrays.toString(frequencyCounter));

            for(char c: s2.toCharArray()){
                frequencyCounter[c - 'a'] =   frequencyCounter[c - 'a'] - 1;
        }

        System.out.println("Second iteration: " + Arrays.toString(frequencyCounter));

        for(int frequency : frequencyCounter){
            if(frequency != 0 ){
                return false;
            }
        }

        return true;
    }
}
