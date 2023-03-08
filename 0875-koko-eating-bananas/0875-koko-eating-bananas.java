class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long ans;
        long start=1;
        long end=0;
        for(int num:piles){
            end+=num;
        }
        ans=end;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(helper(piles,mid)<=(long)h){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return (int)ans;
    }
    public long helper(int[] piles,long k){
        long hours=0;
        for(int num:piles){
            hours+=num%k==0?(num/k):(num/k+1);
        }
        return hours;
    }
}