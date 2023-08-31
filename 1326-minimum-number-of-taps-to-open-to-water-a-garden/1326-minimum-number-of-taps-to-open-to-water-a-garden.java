class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach=new int[n+1];
        for(int i=0;i<ranges.length;i++){
            int start=Math.max(0,i-ranges[i]);
            int end=Math.max(start,i+ranges[i]);
            maxReach[start]=Math.max(maxReach[start],end);
        }
        int taps=0;
        int currTap=0;
        int nextTap=0;
        for(int i=0;i<=n;i++){
            if(i>nextTap){
                return -1;
            }
            if(i>currTap){
                taps++;
                currTap=nextTap;
            }
            nextTap=Math.max(nextTap,maxReach[i]);
        }
        return taps;
    }
}