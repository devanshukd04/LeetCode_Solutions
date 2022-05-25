class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int maxcount=0;
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] dp=new int[envelopes.length];
        if(envelopes.length==0){
            return 0;
        }
        dp[0]=1;
        for(int i=0;i<dp.length;i++){
            int index=binarySearch(dp,0,maxcount,envelopes[i][1]);
            dp[index]=envelopes[i][1];
            if(index==maxcount){
                maxcount++;
            }
        }
        return maxcount;
    }
    public int binarySearch(int[] dp,int a,int b,int target){
        while(a<b){
            int mid=a+(b-a)/2;
            if(dp[mid]==target){
                return mid;
            }
            else if(dp[mid]>target){
                b=mid;
            }
            else{
                a=mid+1;
            }
        }
        return a;
    }
}