class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list=new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for(int[] arr:list){
            if(arr[0]<end && arr[1]>start){
                return false;
            }
        }
        list.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */