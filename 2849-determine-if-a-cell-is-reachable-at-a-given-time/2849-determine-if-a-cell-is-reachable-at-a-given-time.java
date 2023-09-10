class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && sy==fy){
            if(t==1){
                return false;
            }
            return true;
        }
        int distx=Math.abs(sx-fx);
        int disty=Math.abs(sy-fy);
        int minDist=0;
        if(distx>disty){
            minDist=disty+distx-disty;
        }
        else{
            minDist=distx+disty-distx;
        }
        return minDist<=t;
    }
}