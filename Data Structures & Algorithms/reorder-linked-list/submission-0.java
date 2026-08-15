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
    public void reverse(ListNode prev, ListNode slow) {
        if (prev == null || slow == null) return;
        ListNode p1 = slow;
        ListNode p2 = prev;
        ListNode keep = null;
        int count = 0;
        while (p1 != null) {
            if (count == 0) {
                p2.next = null;
            }
            keep = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = keep;
            count++;
        }
    }
    //1->2->3->4<-5<-6<-7
    //

    public void mergeTwoList(ListNode start, ListNode end) {
        while (start != null && end != null && start != end) {
            ListNode keepStart = start.next;
            ListNode keepEnd = end.next;
            start.next = end;
            end.next = keepStart;
            start = keepStart;
            end = keepEnd;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        //Step 1: Slow and fast node
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            fast = fast.next;
        }

        //Step 2: Reverse
        reverse(slow, slow.next);

        ListNode end = fast;

        mergeTwoList(start, end);
    }
}
