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
    // l1.length > l2.length
    public ListNode calcTwoWithLarger(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode res = null;
        ListNode curr = null;
        int remember = 0;
        int count = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + remember;
            remember = num / 10;
            num = num % 10;
            if (curr == null) {
                curr = new ListNode(num);
                if (count == 0) {
                    root = curr;
                }
            } 

            if (res == null) {
                res = curr;
                curr = curr.next;
            } else {
                res.next = curr;
                res = curr;
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;        
            count++;
        }

        while (l1 != null) {
            int num = l1.val + remember;
            remember = num / 10;
            num = num % 10;
            if (curr == null) {
                curr = new ListNode(num);
                if (count == 0) {
                    root = curr;
                }
            } 

            if (res == null) {
                res = curr;
                curr = curr.next;
            } else {
                res.next = curr;
                res = curr;
                curr = curr.next;
            }
            l1 = l1.next;
            count++;
        }

        while (l2 != null) {
            int num = l2.val + remember;
            remember = num / 10;
            num = num % 10;
            if (curr == null) {
                curr = new ListNode(num);
                if (count == 0) {
                    root = curr;
                }
            } 

            if (res == null) {
                res = curr;
                curr = curr.next;
            } else {
                res.next = curr;
                res = curr;
                curr = curr.next;
            }
            l2 = l2.next;        
            count++;
        }

        if (remember > 0) {
            curr = new ListNode(remember);
            res.next = curr;
        }
        return root;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calcTwoWithLarger(l1, l2);        
    }
}
