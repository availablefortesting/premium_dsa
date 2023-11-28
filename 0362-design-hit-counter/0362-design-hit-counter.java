class HitCounter {
    private int[] log;
    private int[] hits;

    public HitCounter() {
        log = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {
        int time = timestamp % 300;
        if (log[time] != timestamp) {
            log[time] = timestamp;
            hits[time] = 0;
        }
        
        hits[time]++;
    }
    
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - log[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */