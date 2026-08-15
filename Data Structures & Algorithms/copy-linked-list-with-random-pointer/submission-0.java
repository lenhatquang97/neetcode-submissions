/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node fullNode = null;
        Node prev = null;
        Node curr = null;
        Node itr = head;
        while (itr != null) {
            if (curr == null) {
                curr = new Node(itr.val);
                fullNode = curr;
            } else {
                curr = new Node(itr.val);
                prev.next = curr;
            }
            prev = curr;
            itr = itr.next;
        }

        Node nowNode = head; 
        Node startNode = fullNode;
        while(nowNode != null && startNode != null) {
            Node keep = nowNode;
            Node keepTmp = startNode;

            Node targetNode = nowNode.random;
            Node tmp = fullNode;
            while (targetNode != null && tmp != null && targetNode.val != tmp.val) {
                tmp = tmp.next;
            }
            if (targetNode == null) {
                startNode.random = null;
            } else {
                startNode.random = tmp;                
            }
            nowNode = keep;
            nowNode = nowNode.next;
            startNode = keepTmp;
            startNode = startNode.next;
        }
        return fullNode;
    }
}
