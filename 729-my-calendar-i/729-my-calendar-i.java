class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer prev=map.floorKey(start);
        Integer next=map.ceilingKey(start);
        if((prev==null || map.get(prev)<=start) && (next==null || end<=next)){
            map.put(start,end);
            return true;
        } 
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */