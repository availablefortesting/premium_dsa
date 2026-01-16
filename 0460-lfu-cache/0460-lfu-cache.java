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
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        } else {
            return null;
        }
    }
}
class LFUCache {
    int cap, size, min_freq;
    Map<Integer, Node> cache;
    Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void update(Node node) {
        DLList oldList = freqMap.get(node.cnt);
        oldList.remove(node);

        if (node.cnt == min_freq && oldList.size == 0) min_freq++;
        node.cnt++;

        freqMap.computeIfAbsent(node.cnt, k -> new DLList()).add(node);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            update(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            update(node);
        } else {
            if (size == cap) {
                cache.remove(freqMap.get(min_freq).removeLast().key);
                size--;
            }

            Node node = new Node(key, value);
            cache.put(key, node);
            size++;

            min_freq = 1;
            freqMap.computeIfAbsent(node.cnt, k -> new DLList()).add(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */