class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] c=new int[rocks.length];
        int a=0;
        int b;
        for(int i=0;i<capacity.length;i++){
            c[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(c);
        for(int i=0;i<c.length;i++){
            if(c[i]==0){
                a++;
            }
            else if(additionalRocks>=c[i]){
                additionalRocks-=c[i];
                c[i]=0;
                a++;
            }
            else{
                return a;
            }
        }
        return a;
    }
}