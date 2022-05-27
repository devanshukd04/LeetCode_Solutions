class Solution {
    public int reverse(int x) {
        int a=0;
        int b=0;
        boolean stat=false;
        if(x==0){
            return x;
        }
        if(x<0){
            stat=true;
            x=0-x;
        }
        while(x>0){
            
            b=x%10;
            if(a>((Math.pow(2,31)-1)/10)){
            return 0;
        }
            else if(a==((Math.pow(2,31)-1)/10) && b>((Math.pow(2,31)-1)%10)){
            return 0;
        }    
            a=a*10+b;
            x=x/10;    
        }
        if(stat){
            a=a-2*a;
        }
        return a;
    }
}