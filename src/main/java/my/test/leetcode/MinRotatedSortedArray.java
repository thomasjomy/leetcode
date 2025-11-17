package my.test.leetcode;

/*
Solve in o(log n)
Use binary search
 */
public class MinRotatedSortedArray {
    public static void main(String[] args) {
        int[] rotatedSortedArray = { 7, 9, 10, 11, 12, 13,14,15,16,17,1, 2, 3, 4, 5, 6};

        int ans = findMininum(rotatedSortedArray);
        System.out.println("answer : " + ans);
    }

    private static int findMininum(int[] rotatedSortedArray) {
        int leftIndex = 0;
        int rightIndex = rotatedSortedArray.length - 1;
        int ans = rotatedSortedArray[0];

        if (rotatedSortedArray.length == 1) {
            return rotatedSortedArray[0];
        }

        while (leftIndex <= rightIndex) {
            System.out.println("leftIndex : " + leftIndex + " rightIndex: " + rightIndex + " Answer Intermediate : " + ans);
            if (rotatedSortedArray[leftIndex] < rotatedSortedArray[rightIndex]) {
                ans = Math.min(ans, rotatedSortedArray[leftIndex]);
            }

            int midIndex = (leftIndex + rightIndex) / 2;
            int midIndexElement = rotatedSortedArray[midIndex];
            System.out.println("midIndexElement : " + midIndexElement);
            ans = Math.min(ans, midIndexElement);
            if (rotatedSortedArray[leftIndex] < rotatedSortedArray[midIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }

        }

        return ans;
    }
}
