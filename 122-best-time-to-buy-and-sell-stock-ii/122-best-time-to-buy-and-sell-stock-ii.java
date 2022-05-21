class Solution {
    public int maxProfit(int[] prices) {
        int j=0;
        int min=prices[0];
        int maxsum=0;
        int sum=0;
        int max=0;
        while(j<prices.length){
        for(int i=j;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            sum=prices[i]-min;
            if(max<sum){    
                max=sum;
                j=i;
                break;
            }
        }
        if(max==0){
            j=prices.length;
        }
        maxsum+=max;
        max=0;
        min=Integer.MAX_VALUE;
        }
        return maxsum;
    }
}