class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] arr=new boolean[rooms.size()];
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(0);
        arr[0]=true;
        while(!stack.isEmpty()){
            int a=stack.pop();
            List<Integer> list=rooms.get(a);
            for(int num:list){
                if(!arr[num]){
                    arr[num]=true;
                    stack.push(num);
                }
            }
        }
        for(boolean a:arr){
            if(!a){
                return false;
            }
        }
        return true;
    }
}