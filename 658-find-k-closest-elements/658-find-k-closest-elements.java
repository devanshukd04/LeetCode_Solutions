class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pqueue=new PriorityQueue<Integer>();
        Queue<Integer> queue=new LinkedList<Integer>();
        List<Integer> ans=new ArrayList<Integer>();
        for(int num:arr){
            pqueue.add(num);
        }
        while(!pqueue.isEmpty()){
            if(queue.size()<k){
                queue.add(pqueue.remove());
            }
            else{
                if(Math.abs(queue.peek()-x)>Math.abs(pqueue.peek()-x)){
                    queue.remove();
                    queue.add(pqueue.remove());
                }
                else{
                    pqueue.remove();
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.remove());
        }
        return ans;
    }
}