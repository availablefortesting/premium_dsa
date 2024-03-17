class CountIntervals {
    TreeMap<Integer, Integer> sorted_intervals;
    int count;
    
    public CountIntervals() {
        this.sorted_intervals = new TreeMap<>();
        this.count = 0;
    }
    
    public void add(int left, int right) {
        var interval = this.sorted_intervals.floorEntry(left);
        // insert at first or last index
        if (interval == null || interval.getValue() < left)
            interval = this.sorted_intervals.higherEntry(left);
        
        // merge next overlapping intervals
        while (interval != null && interval.getKey() <= right) {
            left = Math.min(left, interval.getKey());
            right = Math.max(right, interval.getValue());
            
            // remove all overlapping intervals and its nums counts as well
            this.count -= (interval.getValue() - interval.getKey() + 1);
            this.sorted_intervals.remove(interval.getKey());
            
            interval = this.sorted_intervals.higherEntry(left);
        }
        
        // add newlly processed interval
        this.sorted_intervals.put(left, right);
        this.count += (right - left + 1);
    }
    
    public int count() {
        return this.count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */