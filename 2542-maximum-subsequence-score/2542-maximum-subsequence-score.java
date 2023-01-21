class Solution {
    class Pair{
        int num1;
        int num2;
        Pair(int num1,int num2){
            this.num1=num1;
            this.num2=num2;
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] arr=new Pair[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=new Pair(nums1[i],nums2[i]);
        }
        Arrays.sort(arr,(a,b)->(a.num1==b.num1)?(b.num2-a.num2):(b.num1-a.num1));
        PriorityQueue<Pair> pqueue=new PriorityQueue<Pair>((a,b)->a.num2-b.num2);
        long ans=0;
        long sum=0;
        for(int i=0;i<nums1.length;i++){
            pqueue.add(arr[i]);
            sum+=arr[i].num1;
            if(pqueue.size()>k){
                sum-=pqueue.poll().num1;
            }
            if(pqueue.size()==k){
                ans=Math.max(ans,sum*pqueue.peek().num2);
            }
        }
        return ans;
    }
}