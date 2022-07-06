class Solution {
    public int fib(int n) {
        int a=0;
        int b=1;
        if(n==0){
            return 0;
        }
        while(n-2>0){
            int temp=a+b;
            a=b;
            b=temp;
            n--;
        }
        return a+b;
    }
}