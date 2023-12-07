class MyHashMap {
    private final int table_size = 1001;
    private final int bucket_size = 1001;
    private int[][] map;
    
    public MyHashMap() {
        this.map = new int[this.table_size][this.bucket_size];
        System.out.println(this.map.length);
        for (int[] row: this.map)
            Arrays.fill(row, -1);
    }
    
    // private int[] hash(int key) {
    //     return new int[]{
    //         key / this.bucket_size,
    //         key % this.bucket_size
    //     };
    // }
    
    private int getBucketNo(int key) {
        return key / this.bucket_size;
    }
    
    private int getBucketKey(int key) {
        return key % this.bucket_size;
    }
    
    public void put(int key, int value) {
        this.map[getBucketNo(key)][getBucketKey(key)] = value;
    }
    
    public int get(int key) {
        return this.map[getBucketNo(key)][getBucketKey(key)];
    }
    
    public void remove(int key) {
        this.map[getBucketNo(key)][getBucketKey(key)] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */