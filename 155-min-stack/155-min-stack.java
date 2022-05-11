class MinStack {

    int minTillNow;
    Stack<int[]> stack;
    
    public MinStack() {
        minTillNow = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        minTillNow = Math.min(minTillNow, val);
        stack.push(new int[]{ val, minTillNow });
    }
    
    public void pop() {
        int[] elem = stack.pop();
        minTillNow = stack.empty() ? Integer.MAX_VALUE : stack.peek()[1];
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */