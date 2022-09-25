class MyCircularQueue {
    int[] arr;
    int start=-1;
    int end=-1;
    public MyCircularQueue(int k) {
        arr=new int[k];
    }
    
    public boolean enQueue(int value) {
        if(start==-1){
            arr[++start]=value;
            end=start;
            return true;
        }
        if((end+1)%arr.length==start){
            return false;
        }
        end=(end+1)%arr.length;
        arr[end]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(start==-1){
            return false;
        }
        if(start==end){
            start=-1;
            end=-1;
            return true;
        }
        start=(start+1)%arr.length;
        return true;
    }
    
    public int Front() {
        return start!=-1?arr[start]:start;
    }
    
    public int Rear() {
        return start!=-1?arr[end]:start;
    }
    
    public boolean isEmpty() {
        return start==-1?true:false;
    }
    
    public boolean isFull() {
        if((end+1)%arr.length==start){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */