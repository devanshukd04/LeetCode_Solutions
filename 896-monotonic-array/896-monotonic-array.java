class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1){
            return true;
        }
        boolean flag=true;
        boolean flag1=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                flag=false;
                break;
            }
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                flag1=false;
                break;
            }
        }  
        return flag || flag1;
    }
}