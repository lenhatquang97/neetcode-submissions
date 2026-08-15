class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> hashMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hashMap.containsKey(key)) {
            return -1;
        }
        Node cacheValue = hashMap.get(key);
        delete(cacheValue);
        add(cacheValue);
        return cacheValue.value;
    }
    
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node cacheValue = hashMap.get(key);
            delete(cacheValue);
        }

        Node node = new Node(key, value);
        hashMap.put(key, node);
        add(node);

        if (hashMap.size() > capacity) {
            Node nodeToDelete = tail.prev;
            delete(nodeToDelete);
            hashMap.remove(nodeToDelete.key);
        }
    }

    public void add(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }
}
