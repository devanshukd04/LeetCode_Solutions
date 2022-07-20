class SnapshotArray {
    HashMap<Integer,Integer>[] map;
    int currsnap_id;
    public SnapshotArray(int length) {
        this.map=new HashMap[length]; 
        for(int i=0;i<length;i++){
            map[i]=new HashMap<Integer,Integer>();
            map[i].put(0,0);
        }
        this.currsnap_id=0;
    }
    
    public void set(int index, int val) {
        map[index].put(currsnap_id,val);
    }
    
    public int snap() {
        return currsnap_id++;
    }
    
    public int get(int index, int snap_id) {
        for(int i=snap_id;i>=0;i--){
            if(map[index].containsKey(i)){
                return map[index].get(i);
            }
        }
        return 0;
    }
}