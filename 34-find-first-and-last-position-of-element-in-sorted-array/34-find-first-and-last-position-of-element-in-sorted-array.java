class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        if(nums.length==0){
            return ans;
        }
        while(start<=end && start>=0 && end<nums.length){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;
            }
            else if(nums[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        start=ans[0];
        end=nums.length-1;
         while(start<=end && start>=0 && end<nums.length){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                start=mid+1;
            }
            else if(nums[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}