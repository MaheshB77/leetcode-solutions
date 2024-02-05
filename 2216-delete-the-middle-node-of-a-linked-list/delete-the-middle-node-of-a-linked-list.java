/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // return solution1(head);
        return solution2(head);
    }

    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public ListNode solution1(ListNode head) {
        int length = length(head);
        if (length == 1) {
            return null;
        }
        int middle = length / 2;
        int counter = 0;
        ListNode temp = head;
        while (temp.next != null) {
            if (counter == middle - 1) {
                temp.next = temp.next.next;
                break;
            }
            counter++;
            temp = temp.next;
        }
        return head;
    }

    public int length(ListNode head) {
        if (head == null)
            return 0;
        ListNode temp = head;
        int counter = 1;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
}