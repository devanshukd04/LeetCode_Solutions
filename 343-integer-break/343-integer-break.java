class Solution {
    public int integerBreak(int n) {
        if(n==2 || n==3){
            return n==2?1:2;
        }
        return helper(n,1);
    }
    public int helper(int n,int i){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(i>n || n<0){
            return 0;
        }
        int notTake=helper(n,i+1);
        int take=i*helper(n-i,i);
        return Math.max(take,notTake);
    }
}