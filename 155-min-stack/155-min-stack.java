class MinStack {
    List<Integer> list; 
    public MinStack() {
        list=new ArrayList<Integer>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        int a=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            if(a>list.get(i)){
                a=list.get(i);
            }
        }
        return a;
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