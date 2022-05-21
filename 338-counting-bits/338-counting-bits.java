class Solution {
    public int[] countBits(int n) {
        int j=0;
        int[] nobits=new int[n+1];
        for(int i=0;i<=n;i++){
            j=i;
           while(j>0){
               if(j%2!=0){
                   ++nobits[i];
               }
               j=j/2;
           }
        }
        return nobits;
    }
}