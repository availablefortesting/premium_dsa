class RLEIterator {
    int[] data;
    int index;

    public RLEIterator(int[] encoding) {
        data = encoding; index = 0; 
    }
    
    public int next(int n) {
        while (index < data.length && n > 0) {
            int freq = data[index];
            if (freq >= n) {
                data[index] -= n;
                return data[index + 1];
            } else {
                n -= freq;
                data[index] = 0;
                index += 2;
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */