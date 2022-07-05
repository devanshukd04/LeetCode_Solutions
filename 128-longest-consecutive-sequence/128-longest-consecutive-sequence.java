class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> a=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }
        int b=-2;
        int maxcount=-1;
        int count=0;
        int c;
        while(!a.isEmpty()){
            c=a.poll();
            if(c-1==b){
                count++;
                b=c;
            }
            else if(c!=b){
                b=c;
                maxcount=maxcount>count?maxcount:count;
                count=1;   
            }
        }
        maxcount=maxcount>count?maxcount:count;
        return maxcount;
    }
}