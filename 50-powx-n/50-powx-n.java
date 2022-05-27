class Solution {
    public double myPow(double x, int n) {
        double a;
        int i=1;
        if(n==0){
            return 1;
        }
        else if(x==1){
            return 1;
        }
        else if(n>0){
            a=Pow(x,n);
            return a;
        }
        else{
            a=Pow(x,n-2*n);
            return 1/a;
        }
    }
    public double Pow(double x,int n){
        double b;
        if(n==0){
            return 1;
        }
        else{
            b=Pow(x,n/2);
            if(n%2==0){
                return b*b;
            }
            else{
                return x*b*b;
            }
        }
    }
}