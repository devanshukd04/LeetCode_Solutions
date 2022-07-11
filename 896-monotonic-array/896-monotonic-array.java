class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int i=0;
        boolean flag=false;
        boolean flag1=false;
        while(i<nums.length-1){
            if(!flag){
                if(nums[i]>nums[i+1]){
                    flag1=true;
                    flag=true;
                }
                else if(nums[i]<nums[i+1]){
                    flag1=false;
                    flag=true;
                }
            }
            else{
                if(flag1 && nums[i]>=nums[i+1]){
                    flag1=true;
                }
                else if(!flag1 && nums[i]<=nums[i+1]){
                    flag1=false;
                }
                else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}