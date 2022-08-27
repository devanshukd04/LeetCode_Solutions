class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(nums.length==1){
            return sum;
        }
        int ans1=Integer.MIN_VALUE;
        int cur=Integer.MIN_VALUE;
        for(int x:nums){
            cur=x+Math.max(cur,0);
            ans1=Math.max(ans1,cur);
        }
        int ans2=Integer.MAX_VALUE;
        cur=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;++i){
            cur=nums[i]+Math.min(cur,0);
            ans2=Math.min(ans2,cur);
        }
        ans2=sum-ans2;
        int ans3=Integer.MAX_VALUE;
        cur=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;++i){
            cur=nums[i]+Math.min(cur,0);
            ans3=Math.min(ans3,cur);
        }
        return Math.max(ans1,Math.max(ans2,ans3));
    }
}