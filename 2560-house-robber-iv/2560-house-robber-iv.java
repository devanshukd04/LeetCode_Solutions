class Solution {
    int ans=Integer.MAX_VALUE;
    public int minCapability(int[] nums, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int num:nums){
            start=start>num?num:start;
            end=end<num?num:end;
        }
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            int take=k;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    take--;
                    i++;
                }
            }
            if(take<=0){
                end=mid-1;
                ans=ans<mid?ans:mid;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}