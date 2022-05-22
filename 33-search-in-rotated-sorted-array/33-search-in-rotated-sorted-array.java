class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int a=0;
        int j=nums.length-1;
        if(nums[0]>nums[nums.length-1]){
        if(nums[0]<nums[1]){
        while(i<=j){
            if(nums[(i+j)/2]>nums[(i+j)/2+1]){
                j=(i+j)/2;
                break;
            }
            else if(nums[(i+j)/2]<nums[(i+j)/2+1] && nums[(i+j)/2]>=nums[0]){
                i=(i+j)/2+1;
            }
            else{
                j=(i+j)/2-1;
            }
        }
        a=j;
        i=0;
        }
        else{
        j=0;        
            }
        while(i<=j){
            if(nums[(i+j)/2]>target){
                j=(i+j)/2-1;
            }
            else if(nums[(i+j)/2]<target){
                i=(i+j)/2+1;
            }
            else{
                return (i+j)/2;
            }
        }
        i=a+1;
        j=nums.length-1;
        }
        while(i<=j){
            if(nums[(i+j)/2]>target){
                j=(i+j)/2-1;
            }
            else if(nums[(i+j)/2]<target){
                i=(i+j)/2+1;
            }
            else{
                return (i+j)/2;
            }
        }
        return -1;
    }
}