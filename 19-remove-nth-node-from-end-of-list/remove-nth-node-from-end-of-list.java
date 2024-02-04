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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        head = reverse(head);
        ListNode temp = head;
        int count = 1;
        while (temp != null && count < n - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == head && n == 1) {
            head = temp.next;
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
        head = reverse(head);
        return head;
    }

    public ListNode reverse(ListNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        ListNode curr = headNode;
        ListNode prev = null;
        ListNode adv = null;
        while (curr != null) {
            adv = curr.next;
            curr.next = prev;
            prev = curr;
            curr = adv;
        }
        headNode = prev;
        return headNode;
    }
}