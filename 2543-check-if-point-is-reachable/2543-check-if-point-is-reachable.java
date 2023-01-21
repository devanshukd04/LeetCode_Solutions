class Solution {
    public boolean isReachable(int targetX, int targetY) {
        while(targetX>0 && targetX%2==0){
            targetX/=2;
        }
        while(targetY>0 && targetY%2==0){
            targetY/=2;
        }
        int x=targetX;
        int y=targetY;
        if(gcd(x,y)==1){
            return true;
        }
        return false;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}