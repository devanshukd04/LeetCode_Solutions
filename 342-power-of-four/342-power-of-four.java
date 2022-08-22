class Solution {
    public boolean isPowerOfFour(int n) {
        boolean flag=true;
        if(n<=0){
            return false;
        }
        while(n>0){
            if(((n&1)==1 && (n>1)) || ((n&1)==1 && !flag)){
                return false;
            }
            n=n>>1;
            flag=!flag;
        }
        return true;
    }
}