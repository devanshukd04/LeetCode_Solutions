class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    public int pop() {
        int a;
        while(q1.size()>1){
            top=q1.remove();
            q2.add(top);
        }
        a=q1.remove();
        Queue<Integer> b=q1;
        q1=q2;
        q2=b;
        return a;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */