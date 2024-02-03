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
    public ListNode oddEvenList(ListNode head) {
        // return brutForce(head);
        return optimalSolution(head);
    }

    public ListNode optimalSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
        Time -> O(n)
        Space -> O(1)
     */
    public ListNode brutForce(ListNode head) {
        if (head == null) {
            return head;
        }
        List<Integer> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.val);
        }
        temp = head.next;
        while(temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        temp = head;
        for (Integer num : list) {
            temp.val = num;
            temp = temp.next;
        }
        return head;
    }
}