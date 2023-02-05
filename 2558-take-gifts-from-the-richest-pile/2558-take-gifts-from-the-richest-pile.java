class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num:gifts){
            queue.add(num);
        }
        for(int i=0;i<k;i++){
            int temp=queue.poll();
            temp=(int)Math.floor(Math.sqrt(temp));
            queue.add(temp);
        }
        long ans=0;
        while(!queue.isEmpty()){
            ans+=queue.poll();
        }
        return ans;
    }
}