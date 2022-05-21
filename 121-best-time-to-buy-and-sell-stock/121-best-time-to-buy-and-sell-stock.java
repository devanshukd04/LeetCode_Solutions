class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxsum=0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            sum=prices[i]-min;
            if(maxsum<sum){
                maxsum=sum;
            }
        }
        return maxsum;
    }
}