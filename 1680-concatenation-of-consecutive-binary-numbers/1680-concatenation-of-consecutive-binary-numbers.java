class Solution {
    public int concatenatedBinary(int n) {
        List<Integer> ans=new ArrayList<Integer>();
        long res=0;
        int bit=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                bit++;             
            }
            res=((res<<bit)+i)%((int)1e9+7);
        }
        return (int)res;
    }
}