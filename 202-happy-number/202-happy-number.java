class Solution {
    public boolean isHappy(int n) {
        int slowPointer=getNext(n);
        int fastPointer=getNext(getNext(n));
        while(slowPointer!=1 || fastPointer!=1){
            if(slowPointer==fastPointer){
                return false;
            }
            slowPointer=getNext(slowPointer);
            fastPointer=getNext(getNext(fastPointer));
        }
        return true;
    }
    public int getNext(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}