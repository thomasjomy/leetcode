package my.test.leetcode.linkedlist;

public class PrintList {

    public static void printList(final ListNode head) {
        ListNode temp = head;
        System.out.println("\n--------------------------------------------");
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
            if (temp != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
