class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum1=0;
        int min=cardPoints[0];
        for(int i=0;i<cardPoints.length;i++){
            min=min<cardPoints[i]?min:cardPoints[i];
            sum1+=cardPoints[i];
        }
        int a=0;
        int b=0;
        int n=cardPoints.length-k;
        if(n==0){
            return sum1;
        }
        if(n==1){
            return sum1-min;
        }
        int sum=cardPoints[0];
        int minsum=Integer.MAX_VALUE;
        while(b<cardPoints.length-1 && b>=a){
            if(b-a+1<n){
                b++;
                sum+=cardPoints[b];
            }
            if(b-a+1>n){
                sum-=cardPoints[a];
                a++;
            }
            if(b-a+1==n){
                minsum=sum<minsum?sum:minsum;
                sum-=cardPoints[a];
                a++;
            }
        }
        return sum1-minsum;
    }
}