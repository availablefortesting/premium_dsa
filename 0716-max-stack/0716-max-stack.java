class MaxStack {

    private TreeSet<int[]> stack;
    private TreeSet<int[]> maxStack;
    private int idx;
    
    public MaxStack() {
        Comparator<int[]> comp = (a, b) -> {
            // specially for maxStack, normal stack anyway have unique index
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];  
        };
        
        stack = new TreeSet<>(comp);
        maxStack = new TreeSet<>(comp);
        idx = 0;
    }
    
    public void push(int x) {
        stack.add(new int[] {idx, x} );
        maxStack.add(new int[] {x, idx} );
        ++idx;
    }
    
    public int pop() {
        int[] last = stack.pollLast();
        maxStack.remove(new int[] {last[1], last[0]});
        return last[1]; 
    }
    
    public int top() {
        return stack.last()[1];   
    }
    
    public int peekMax() {
        return maxStack.last()[0];
    }
    
    public int popMax() {
        int[] last = maxStack.pollLast();
        stack.remove(new int[] {last[1], last[0]});
        return last[0]; 
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */