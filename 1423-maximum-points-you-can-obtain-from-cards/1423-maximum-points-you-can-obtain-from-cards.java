class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum1=0;
        for(int i=0;i<cardPoints.length;i++){
            sum1+=cardPoints[i];
        }
        int a=0;
        int b=0;
        int n=cardPoints.length-k;
        if(n==0){
            return sum1;
        }
        int sum=cardPoints[0];
        int minsum=Integer.MAX_VALUE;
        while(b<cardPoints.length && b>=a){
            if(b-a+1<n){
                if(++b<cardPoints.length){
                    sum+=cardPoints[b];   
                }
                else{
                    break;
                }
            }
            if(b-a+1>n){
                sum-=cardPoints[a];
                a++;
            }
            if(b-a+1==n){
                minsum=sum<minsum?sum:minsum;
                if(++b<cardPoints.length){
                    sum+=cardPoints[b];   
                }
                else{
                    break;
                }
                
            }
        }
        return sum1-minsum;
    }
}