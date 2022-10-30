class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long ans=n;
        long res=n;
        int pow=1;
        while(digitSum(res)>target){
            n/=10;
            res=(long)((n+1)*Math.pow(10,pow));
            ++pow;
        }
        return res-ans;
    }
    public int digitSum(long n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}