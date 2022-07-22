class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] arr=new boolean[rooms.size()];
        visitRooms(arr,rooms,0);
        for(boolean a:arr){
            if(!a){
                return false;
            }
        }
        return true;
    }
    public void visitRooms(boolean[] arr,List<List<Integer>> rooms,int i){
        List<Integer> list=rooms.get(i);
        arr[i]=true;
        int j=0;
        while(j<list.size()){
            if(!arr[list.get(j)]){
                visitRooms(arr,rooms,list.get(j));
            }
            ++j;
        }
        return;
    }
}