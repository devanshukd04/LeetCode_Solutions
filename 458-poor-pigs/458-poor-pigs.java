class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int period=minutesToTest/minutesToDie+1;
        int ans=0;
        while(Math.pow(period,ans)<buckets){
            ans++;
        }
        return ans;
    }
}