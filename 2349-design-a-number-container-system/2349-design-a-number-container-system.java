class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> valuemap;
    HashMap<Integer,Integer> indexmap;
    public NumberContainers() {
        this.valuemap=new HashMap<Integer,TreeSet<Integer>>();
        this.indexmap=new HashMap<Integer,Integer>();
    }
    
    public void change(int index, int number) {
        if(indexmap.containsKey(index)){
            int prevnumber=indexmap.get(index);
            indexmap.put(index,number);   
            valuemap.get(prevnumber).remove(index);
            if(!valuemap.containsKey(number)){
                valuemap.put(number,new TreeSet<>());
            }
            valuemap.get(number).add(index);
        }
        else{
            indexmap.put(index,number); 
            if(!valuemap.containsKey(number)){
                valuemap.put(number,new TreeSet<>());
            }
            valuemap.get(number).add(index);
        }
    }
    
    public int find(int number) {
        if(valuemap.containsKey(number)){
            for(Integer num:valuemap.get(number)){
                return num;
            }
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */