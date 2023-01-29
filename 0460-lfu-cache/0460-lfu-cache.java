class LFUCache {
    class Pair{
        int key;
        int frequency;
        int lastCall;
        int value;
        Pair(int key,int frequency,int lastCall,int value){
            this.key=key;
            this.frequency=frequency;
            this.lastCall=lastCall;
            this.value=value;
        }
    }
    HashMap<Integer,Pair> map;
    PriorityQueue<Integer> queue;
    int count;
    int capacity;
    public LFUCache(int capacity) {
        this.map=new HashMap<Integer,Pair>();
        this.queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                if(map.get(a).frequency>map.get(b).frequency){
                    return 1;
                }
                else if(map.get(a).frequency==map.get(b).frequency){
                    return map.get(a).lastCall-map.get(b).lastCall;
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
        Pair temp=map.get(key);
        temp.lastCall=count++;
        temp.frequency+=1;
        queue.remove(key);
        queue.add(key);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Pair temp=map.get(key);
            temp.lastCall=count;
            temp.frequency+=1;
            temp.value=value;
            queue.remove(key);
            queue.add(key);
            return;
        }
        if(map.size()==capacity){
            map.remove(queue.poll());
        }
        Pair pair=new Pair(key,1,count,value);
        map.put(key,pair);
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