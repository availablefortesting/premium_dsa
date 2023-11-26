class MovingAverage {
    ArrayDeque<Integer> dq;
    int size;
    double cur_sum;
    
    public MovingAverage(int size) {
        this.dq = new ArrayDeque<>();
        this.size = size;
        this.cur_sum = 0;
    }
    
    public double next(int val) {
        this.dq.add(val);
        this.cur_sum += val;
        
        int n = this.dq.size();
        if (n > this.size) {
            this.cur_sum -= this.dq.poll();
            n -= 1;
        }
        
        return this.cur_sum / n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */