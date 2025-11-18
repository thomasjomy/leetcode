package my.test.leetcode.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous;
        ListNode current;
        ListNode next;
        previous = head;
        current = head.next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = null;
        return previous;
    }
}
