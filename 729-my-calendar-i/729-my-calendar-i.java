class MyCalendar {
    HashMap<Integer,Integer> map;
    PriorityQueue<Integer> queue;
    public MyCalendar() {
        map=new HashMap<Integer,Integer>();
        queue=new PriorityQueue<Integer>();
    }
    
    public boolean book(int start, int end) {
        List<Integer> list=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int oldstart=queue.poll();
            list.add(oldstart);
            if(oldstart<end && start<map.get(oldstart)){
                for(int num:list){
                    queue.add(num);
                }
                return false;
            }
        }
        for(int num:list){
            queue.add(num);
        }
        map.put(start,end);
        queue.add(start);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */