class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num:stones){
            queue.add(num);
        }
        while(queue.size()>1){
            int a,b;
            a=queue.poll();
            b=queue.poll();
            if(a!=b){
                queue.add(a-b);
            }
        }
        return queue.size()>0?queue.poll():0;
    }
}