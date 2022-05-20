class MyHashSet {
    List<Integer> a;
    public MyHashSet() {
        a=new ArrayList<Integer>();  
    }
    
    public void add(int key) {
        if(!(a.contains(key))){
            a.add(key);
        }
    }
    
    public void remove(int key) {
        a.remove(new Integer(key));
    }
    
    public boolean contains(int key) {
        if(a.contains(key)){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */