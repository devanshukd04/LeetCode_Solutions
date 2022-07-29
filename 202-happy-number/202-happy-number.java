class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<Integer>();
        while(n!=1){
            int sum=0;
            if(set.contains(n)){
                break;
            }
            set.add(n);
            while(n>0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            n=sum;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}