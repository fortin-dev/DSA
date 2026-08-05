/*
LRU Cache
Medium
Topics - Hash Table, Linked List, Design , Doubly-Linked List
Company Tags - Twitch
Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
LRUCache(int capacity) Initialize the LRU cache of size capacity.
int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
A key is considered used if a get or a put operation is called on it.

Ensure that get and put each run in O(1) average time complexity.
*/
class LRUCache {
    Node head, tail;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }

    public void addNode(Node n){
        n.next = head.next;
        n.prev = head;

        head.next.prev = n;
        head.next = n;
    }

    public void removeNode(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void moveToHead(Node n){
        removeNode(n);
        addNode(n);
    }

    public Node popTail(){
        Node n = tail.prev;
        removeNode(n);
        return n;
    }

    Map<Integer, Node> map = new HashMap();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null) return -1;
        moveToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null){
            n.val = value;
            moveToHead(n);
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;

            if(map.size() >= capacity){
                Node tail = popTail();
                map.remove(tail.key);
            }

            map.put(key, node);
            addNode(node);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */