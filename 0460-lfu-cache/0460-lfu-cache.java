class Node {
    int key, val, cnt;
    
    Node prev, next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        cnt = 1;
    }
}

class DLList {
    Node head, tail;
    int size;
    
    DLList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void add(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size > 0) {
            Node node = tail.prev;
            remove(node);
            return node;
        }
        else return null;
    }
}
    
class LFUCache {
    int capacity, size, min_freq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> countMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) 
            return;
        
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            // if we overload capacity (because we know for sure we are adding one new Node)
            if (size == capacity) {
                DLList least_freq_nodes = countMap.get(min_freq);
                nodeMap.remove(least_freq_nodes.removeLast().key);
                size--;
            }
            
            // add new key-val pair
            node = new Node(key, value);
            nodeMap.put(key, node);
            size++;
            
            // now min_freq will because 1
            min_freq = 1;
            DLList newList = countMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countMap.put(node.cnt, newList);
        }
    }
    
    private void update(Node node) {
        // get old DLL and remove node from it
        DLList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        
        // now update the min_freq_count 
        if (node.cnt == min_freq && oldList.size == 0) min_freq++; 
        node.cnt++;
        
        // add new freq cnt in countMap
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */