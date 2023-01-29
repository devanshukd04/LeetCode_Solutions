class LFUCache {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Integer> sequence;
    HashMap<Integer,Integer> pair;
    PriorityQueue<Integer> queue;
    int count;
    int capacity;
    public LFUCache(int capacity) {
        this.map=new HashMap<Integer,Integer>();
        this.sequence=new HashMap<Integer,Integer>();
        this.pair=new HashMap<Integer,Integer>();
        this.queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                if(map.get(a)>map.get(b)){
                    return 1;
                }
                else if(map.get(a)==map.get(b)){
                    return sequence.get(a)-sequence.get(b);
                }
                else{
                    return -1;
                }
            }
        });
        count=0;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key) || capacity==0){
            return -1;
        }
        map.put(key,map.get(key)+1);
        sequence.put(key,count);
        queue.remove(key);
        queue.add(key);
        ++count;
        return pair.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        pair.put(key,value);
        sequence.put(key,count);
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
            queue.remove(key);
            queue.add(key);
            return;
        }
        if(queue.size()==capacity){
            int temp=queue.poll();
            map.remove(temp);
            pair.remove(temp);
            sequence.remove(temp);
        }
        map.put(key,1);
        queue.add(key);
        ++count;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */