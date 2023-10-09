class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=binarySearchFirst(nums,target);
        ans[1]=binarySearchLast(nums,target);
        return ans;
    }
    public int binarySearchFirst(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return index;
    }
    public int binarySearchLast(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
                start=mid+1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return index;   
    }
}