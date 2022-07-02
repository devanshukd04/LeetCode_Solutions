class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long a=0;
        long b=0;
        long c=(long)1e9+7;
        long hsum=-1;
        long csum=-1;
        for(int i=0;i<horizontalCuts.length;i++){
            if(horizontalCuts[i]-a>hsum){
                hsum=horizontalCuts[i]-a;
            }
            a=horizontalCuts[i];
        }
        if(h-a>hsum){
            hsum=h-a;
        }
        for(int i=0;i<verticalCuts.length;i++){
            if(verticalCuts[i]-b>csum){
                csum=verticalCuts[i]-b;
            }
            b=verticalCuts[i];
        }
        if(w-b>csum){
            csum=w-b;
        }
        return (int)((hsum*csum)%c);
    }
}