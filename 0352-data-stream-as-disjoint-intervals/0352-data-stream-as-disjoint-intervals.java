class SummaryRanges {
    int[] arr;
    HashSet<Integer> set;
    HashMap<Integer,Integer> map;
    HashMap<Integer,Integer> map1;
    public SummaryRanges() {
        this.arr=new int[(int)1e4+2];
        Arrays.fill(this.arr,-1);
        this.map=new HashMap<Integer,Integer>();
        this.map1=new HashMap<Integer,Integer>();
        this.set=new HashSet<Integer>();
    }
    
    public void addNum(int value) {
        if(set.contains(value)){
            return;
        }
        set.add(value);
        int start=helper1(value);
        int end=helper(value);
        if(start==-1 && end==-1){
            map.put(value,value);
            map1.put(value,value);
        }
        else if(start==-1){
            map.put(value,end);
            map1.put(end,value);
        }
        else if(end==-1){
             map.put(start,value);
             map1.put(value,start);
        }
        else{
            map.put(start,end);
            map1.put(end,start);
        }
    }
    
    public int[][] getIntervals() {
        int[][] ans=new int[map.size()][2];
        int i=0;
        for(int key:map.keySet()){
            ans[i][0]=key;
            ans[i][1]=map.get(key);
            i++;
        }
        Arrays.sort(ans,(a,b)->a[0]-b[0]);
        return ans;
    }
    public int helper(int value){
        if(map.containsKey(value+1)){
            int temp=map.get(value+1);
            map.remove(value+1);
            int curr=helper(temp);
            return curr==-1?temp:curr;
        }
        else{
            if(map.containsKey(value)){
                map.remove(value);
            }
            return -1;
        } 
    }
    public int helper1(int value){
        if(map1.containsKey(value-1)){
            int temp=map1.get(value-1);
            map1.remove(value-1);
            int curr=helper1(temp);
            return curr==-1?temp:curr;
        }
        else{
            if(map1.containsKey(value)){
                map1.remove(value);
            }
            return -1;
        } 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */