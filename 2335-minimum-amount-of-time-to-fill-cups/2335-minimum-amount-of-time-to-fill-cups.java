class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count=0;
        int sum=0,max;
        for(int i=0;i<amount.length-1;i++){
            sum+=amount[i];
        }
        max=amount[amount.length-1];
        while(max>0 && sum>0){
            sum--;
            max--;
            count++;
        }
        if(max>0 && sum==0){
            return count+max;
        }
        return count+sum/2+sum%2;
    }
}