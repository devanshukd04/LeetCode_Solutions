class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Long> queue1=new PriorityQueue<Long>(Collections.reverseOrder());
        PriorityQueue<Long> queue2=new PriorityQueue<Long>();
        long sum1=0;
        long sum2=0;
        for(int i=0;i<weights.length-1;i++){
            long pair=weights[i]+weights[i+1];
            queue1.add(pair);
            queue2.add(pair);
            sum1+=pair;
            sum2+=pair;
            if(queue1.size()>(k-1)){
                sum1-=queue1.poll();
            }
            if(queue2.size()>(k-1)){
                sum2-=queue2.poll();
            }
        }
        long ans=Math.abs(sum1-sum2);
        return ans;
    }
}