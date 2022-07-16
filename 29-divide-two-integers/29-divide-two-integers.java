class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag=true;
        long divid,divis;
        if(dividend==Integer.MIN_VALUE){
            if(divisor==1){
                return Integer.MIN_VALUE;
            }
            if(divisor==-1){
                return Integer.MAX_VALUE;
            }
        }
        if(dividend==Integer.MAX_VALUE){
            if(divisor==1){
                return Integer.MAX_VALUE;
            }
            if(divisor==-1){
                return Integer.MIN_VALUE;
            }
        }
        if(dividend<0 || divisor<0){
            if(dividend<0 && divisor<0){
                flag=true;            
            }
            else{
                flag=false;
            }
        }
        divid=(long)dividend;
        divis=(long)divisor;
        if(dividend<0){
            divid-=2*divid;
        }
        if(divisor<0){
            divis-=2*divis;
        }
        long csum=0;
        long result=0;
        for(long i=31;i>=0;i--){
            if((csum+(divis<<i))<=divid){
                csum+=divis<<i;
                result|=1<<i;
            }
        }
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return result>Integer.MAX_VALUE?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(!flag){
            return -(int)result;
        }
        return (int)result;
    }
}