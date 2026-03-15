class RLEIterator {
    Deque<Integer> queue;
    int n;

    public RLEIterator(int[] encoding) {
        this.n = encoding.length;
        this.queue = new ArrayDeque<Integer>();

        for(int i = 0; i < this.n; i++)
            this.queue.addLast(encoding[i]);  
    }
    
    public int next(int n) {
        int freq = 0, num = 0, temp = 0;
        while(n != 0 && this.queue.size() > 0) {
            freq = this.queue.pollFirst();
            num = this.queue.pollFirst();

            temp = n;
            n = Math.max(temp - freq, 0);
            freq = Math.max(freq - temp, 0);

            if (freq != 0) {
                this.queue.addFirst(num);
                this.queue.addFirst(freq);
            }

            if (n == 0) return num;
        }

        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */