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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fastNode = head;
        ListNode slowNode = null;
        ListNode nextNode = null;
        //1 -> 2 -> 3 -> 4
        //
        while (fastNode != null) {
            nextNode = fastNode.next;
            fastNode.next = slowNode;
            slowNode = fastNode;
            fastNode = nextNode;
        } 
        return slowNode;
    }
}
