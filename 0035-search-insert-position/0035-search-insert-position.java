class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        if(nums[0]>=target){
            return 0;
        }
        int start=0;
        int end=nums.length-1;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans+1;
    }
}