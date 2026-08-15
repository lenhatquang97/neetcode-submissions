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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        int count = 0;
        while(slowNode != null && fastNode != null && fastNode.next != null) {
            if (count > 0 && slowNode.val == fastNode.val) return true;
            count++;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;

    }
}
