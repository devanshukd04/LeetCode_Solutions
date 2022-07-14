class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int [] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>target){
                j=mid-1;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }
            else{
                result[0]=mid;
                result[1]=mid;
                int mid1;
                
                mid1=mid;
                --mid1;
                while(mid1>=0 && nums[mid1]==target){
                    mid1--;
                }
                ++mid1;
                result[0]=mid1;
                
                mid1=mid;
                ++mid1;
                while(mid1<nums.length && nums[mid1]==target){
                    mid1++;
                }
                --mid1;
                result[1]=mid1;
                return result;
            }
        }
        return result;
    }
}