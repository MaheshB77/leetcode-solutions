/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // return brutForce(headA, headB);
        // return solution1(headA, headB);
        return solution2(headA, headB);
    }

    public ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (temp1 != temp2) {
            if (temp1 == null) {
                temp1 = head2;
            }
            if (temp2 == null) {
                temp2 = head1;
            }
            if (temp1 == temp2) {
                return temp1;
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    /**
        Time -> O(m) + O(n) + O(m | n)
        Spacec -> O(1)
     */
    public ListNode solution1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int l1 = 0;
        int l2 = 0;
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }

        if (l1 < l2) {
            return getIntersection(headA, headB, l2 - l1);
        } else {
            return getIntersection(headB, headA, l1 - l2);
        }
    }

    /**
        Time -> O(m) + O(n)
        Space -> O(n)
     */
    public ListNode brutForce(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        Set<ListNode> set = new HashSet<>();

        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    // Util methods
    public ListNode getIntersection(ListNode n1, ListNode n2, int diff) {
        while (diff != 0) {
            diff--;
            n2 = n2.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}