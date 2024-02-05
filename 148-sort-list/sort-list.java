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
    public ListNode sortList(ListNode head) {
        // return brutForce(head);
        return brutForce2(head);
    }

    public ListNode brutForce2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        for (Integer num : list) {
            temp.val = num;
            temp = temp.next;
        }
        return head;
    }

    /**
        Time Limit Exceeded in this approach
     */
    public ListNode brutForce(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode outer = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode boundary = null;

        while (p1 != boundary) {
            while (p2 != boundary) {
                if (p1.val > p2.val) {
                    swap(p1, p2);
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            boundary = p1;
            p1 = outer;
            p2 = p1.next;
        }
        return head;
    }

    public void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}