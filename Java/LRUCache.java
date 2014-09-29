import java.util.HashMap;


public class LRUCache {
    /**
     * Structure
     * 
     * @author ouyangyewei
     */
    public class CacheNode {
        public int key;
        public int value;
        public CacheNode prev;
        public CacheNode next;
        
        public CacheNode() {
            // nothing
        }
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private int currentCapacity;
    private CacheNode head;
    private CacheNode tail;
    private HashMap<Integer, CacheNode> hashNode;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.head = null;
        this.tail = null;
        this.hashNode = new HashMap<Integer, CacheNode>();
    }
    
    public int get(int key) {
        CacheNode node = hashNode.get(key);
        if (null == node) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void set(int key, int value) {
        if (null == hashNode.get(key)) {
            /** cacheNode is not exists! */
            CacheNode node = new CacheNode(key, value);
            if (currentCapacity < capacity) {
                /** enough capacity for add a node */
                addToHead(node);
                ++currentCapacity;
            } else {
                /** over the maximum capacity */
                removeLeastUseNode();
                addToHead(node);
                currentCapacity = capacity;
            }
            
            hashNode.put(key, node);
        } else {
            /** cacheNode is already exists */
            CacheNode node = hashNode.get(key);
            node.value = value;
            moveToHead(node);
            hashNode.put(key, node);
        }
    }
    
    /**
     * Move a node to list's head
     * @param node
     */
    public void moveToHead(CacheNode node) {
        if (null != node.prev) {
            /** node locate behind the list's head */
            CacheNode front = node.prev;
            CacheNode behind = node.next;
            if (null == behind) {
                /** node locate at the list's tail */
                front.next = behind;
                tail = front;
            } else {
                front.next = behind;
                behind.prev = front;
            }
            
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    /**
     * Add a node to list's head.
     * @param node
     */
    public void addToHead(CacheNode node) {
        if (null == head) {
            /** list is empty */
            head = node;
            tail = node;
        } else {
            /** list is not empty */
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    /**
     * Remove the least use node, it means remove 
     * the list's tail node.
     */
    public void removeLeastUseNode() {
        if (null != tail.prev) {
            hashNode.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
        } else {
            /** list has only one node */
            hashNode.remove(tail.key);
            head = null;
            tail = null;
        }
    }
    
//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(4);
//        lruCache.set(1, 1);
//        lruCache.set(0, 0);
//        lruCache.get(1);
//        lruCache.get(0);
//        lruCache.set(2, 2);
//        lruCache.set(4, 4);
//        lruCache.get(1);
//        lruCache.get(0);
//        lruCache.get(0);
//        lruCache.set(8, 8);
//        lruCache.set(7, 7);
//        lruCache.set(5, 5);
//        lruCache.set(4, 4);
//        lruCache.set(3, 3);
//        lruCache.set(2, 2);
//        lruCache.get(3);
//        lruCache.get(4);
//        LRUCache lruCache = new LRUCache(1);
//        lruCache.set(2, 1);
//        System.out.println(lruCache.get(2));
//        lruCache.set(3, 2);
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.set(2, 1);
//        lruCache.set(1, 2);
//        lruCache.set(2, 3);
//        lruCache.set(4, 1);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//    }
}
