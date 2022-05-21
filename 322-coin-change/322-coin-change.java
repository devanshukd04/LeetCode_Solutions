class Solution {
    int min=-1;
    public int coinChange(int[] coins, int amount) {
    int a;
    Arrays.sort(coins);
    int[] b=new int[amount+1];
    a=helper(coins,b,amount);
    if(a==-1){
        return -1;
    }
    return a-1;
    }
    public int helper(int[] coins, int[] b, int amount){
        int min1=-1;
        int a;
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return -1;
        }
        if(b[amount]!=0){
            if(b[amount]==-1){
                return -1;
            }
            return b[amount]+1;
        }
        for(int i=coins.length-1;i>=0;i--){
            a=helper(coins,b,amount-coins[i]);
            if(a!=-1){
                if(b[amount]==0 || a<b[amount]){
                    b[amount]=a;
                    min1=a;
                }
            }
        }
        if(min1==-1){
            b[amount]=-1;
            return -1;
        }
        return min1+1;
        // int a;
        // int b;
        // int c;
        // if(amount==0){
        //     return count;
        // }
        // if(i<0){
        //     return -1;
        // }
        // for(int j=i;j>=0;j--){
        //     c=amount;
        //     a=amount/coins[j];
        //     amount%=coins[j];
        //     count+=a;
        //     System.out.println(amount+" "+count+" "+coins[j]);
        //     b=helper(coins,amount,j-1,count);
        //     System.out.println(b+" "+amount+" "+count+" "+coins[j]);
        //     if(b!=-1){
        //         return b;
        //     }
        //     else{
        //         amount=c;
        //     }
        // }
        // return -1;
    }
}