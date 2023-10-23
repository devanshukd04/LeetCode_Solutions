class Solution {
    public boolean isPowerOfFour(int n) {
        
        boolean oddParity=true;

        while(n>0){
            int bit=n&1;
            n>>=1;
            if(bit==1){
                if(oddParity && n==0){
                    return true;
                }
                return false;
            }
            oddParity=!oddParity;
        }
        return false;
    }
}