class Solution {
    public int coinChange(int[] coins, int amount) {
    int a;
    Arrays.sort(coins);
    HashMap<Integer,Integer> b=new HashMap<Integer,Integer>();
    a=helper(coins,b,amount);
    if(a==-1){
        return -1;
    }
    return a-1;
    }
    public int helper(int[] coins, HashMap<Integer,Integer> b, int amount){
        int min=-1;
        int a;
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return -1;
        }
        if(b.containsKey(amount)){
            if(b.get(amount)==-1){
                return -1;
            }
            return b.get(amount)+1;
        }
        for(int i=coins.length-1;i>=0;i--){
            a=helper(coins,b,amount-coins[i]);
            if(a!=-1){
                if(!b.containsKey(amount)){
                    b.put(amount,a);
                    min=a;
                }
                else if(a<b.get(amount)){
                    b.put(amount,a);
                    min=a;
                }
            }
        }
        if(min==-1){
            b.put(amount,-1);
            return -1;
        }
        return min+1;
    }
}