class MyHashMap {
    List<Integer> keys;
    List<Integer> values;
    public MyHashMap() {
        this.keys=new ArrayList<Integer>();
        this.values=new ArrayList<Integer>();
    }
    
    public void put(int key, int value) {
        int a;
        if(keys.contains(key)){
            a=keys.indexOf(key);
            values.set(a,value);
        }
        else{
            keys.add(key);
            values.add(value);
        }
    }
    
    public int get(int key) {
        int a=-1;
        if(keys.contains(key)){
            a=keys.indexOf(key);
            a=values.get(a);
        }
        return a;
    }
    
    public void remove(int key) {
        int a;
        if(keys.contains(key)){
            a=keys.indexOf(key);
            keys.remove(a);
            values.remove(a);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */