class Fancy {
    private List<Long> nums;
    long cumAdd = 0;
    long cumMul = 1;
    int mod = 1000000007;

    // we will store transformation in x*mult + add form
    //   for add it will become x*mult + (add + inc)
    //   for mult it will becaome (x*mult + add) * m = x*(mult*m) + (add*m)
    //   for get we apply the mult and add transformation
    // BUT wait what if we store num and the do getIndex()? it will apply global transformation, which is incorrect
    //    to negate that we have to apply invers global transformation 
    public Fancy() {
        this.nums = new ArrayList<>();
    }
    
    // division is not present in mod world as it returns decimal number
    // so there is two ways,
    //   1) if for 1/a % mod, if mod is prime, then as per Fermat's theorem it will be
    //      pow(a, mod-2) % mod
    public void append(int val) {
        // xm + a = val; -> x = (val - a) / m 
        long addVal = ((val - this.cumAdd) % mod + mod) % mod;  // to have positive num after mod
        addVal = (addVal * this.modPow(this.cumMul, mod-2, mod)) % mod;
        this.nums.add(addVal);
    }
    
    public void addAll(int inc) {
        this.cumAdd = (this.cumAdd + inc) % mod;
    }
    
    public void multAll(int m) {
        this.cumMul = (this.cumMul * m) % mod;
        this.cumAdd = (this.cumAdd * m) % mod;
    }
    
    public int getIndex(int idx) {
        if (idx >= this.nums.size())    return -1;
        return (int) ((this.nums.get(idx) * this.cumMul + this.cumAdd) % mod);
    }

    private long modPow(long x, long y, long mod) {
        long res = 1;
        x %= mod;

        while (y > 0) {
            if ((y & 1) == 1) // odd
                res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */