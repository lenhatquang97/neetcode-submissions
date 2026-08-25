/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> mp = new HashMap<>();
        mp.put(node, new Node(node.val));
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node nei : curr.neighbors) {
                if (!mp.containsKey(nei)) {
                    mp.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                mp.get(curr).neighbors.add(mp.get(nei));
            }
        }
        return mp.get(node);
    }
}