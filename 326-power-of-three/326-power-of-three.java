class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        long temp=1;
        while(temp<n){
            temp+=temp<<1;
        }
        if(temp==n){
            return true;
        }
        return false;
    }
}