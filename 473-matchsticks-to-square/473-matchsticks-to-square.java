class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        int side;
        Arrays.sort(matchsticks);
        for(int i=0;i<matchsticks.length/2;i++){
            int temp=matchsticks[i];
            sum+=temp;
            matchsticks[i]=matchsticks[matchsticks.length-1-i];
            sum+=matchsticks[i];
            matchsticks[matchsticks.length-1-i]=temp;
        }
        if(matchsticks.length%2!=0){
            sum+=matchsticks[matchsticks.length/2];
        }
        if(sum%4!=0){
            return false;
        }
        side=sum/4;
        return validateSquare(0,0,0,0,0,matchsticks,side);
    }
    public boolean validateSquare(int a,int b,int c,int d,int i, int[] matchsticks,int side){
        if(a==b && b==c && c==d && d==side){
            return true;
        }
        if(i==matchsticks.length || a>side || b>side || c>side || d>side){
            return false;
        }
        boolean f;
        int val=matchsticks[i];
        f=validateSquare(a+val,b,c,d,i+1,matchsticks,side);
        if(f){
            return true;
        }
        f=validateSquare(a,b+val,c,d,i+1,matchsticks,side);
        if(f){
            return true;
        }
        f=validateSquare(a,b,c+val,d,i+1,matchsticks,side);
        if(f){
            return true;
        }
        f=validateSquare(a,b,c,d+val,i+1,matchsticks,side);
        if(f){
            return true;
        }
        return false;
    }
}