class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map=new TreeMap<Integer,Integer>();
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int res=0;
        int cur=0;
        for(int value:map.values()){
            cur+=value;
            res=Math.max(res,cur);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */