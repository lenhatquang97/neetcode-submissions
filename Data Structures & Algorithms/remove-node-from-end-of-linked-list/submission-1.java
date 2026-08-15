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
    public int calcN(ListNode head) {
        ListNode ptr = head;
        int n = 0;
        while(head != null) {
            head = head.next;
            n++;
        }
        return n;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (head.next == null && n == 1) return null;
        
        ListNode slow = null;
        ListNode curr = head;

        int leng = calcN(head);
        int i = leng - n;
        int count = 0;

        while(count < i && curr != null) {
            slow = curr;
            curr = curr.next;
            count++;
        }
        if (slow == null) {
            return head.next;
        }
        slow.next = curr.next;
        return head;
    }
}
