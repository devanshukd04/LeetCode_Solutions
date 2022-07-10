class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            //Updating value of a-1 number
            if(nums[i]<a){
                a=nums[i];
            }
            //Updating value of b-2 number 
            if(nums[i]<b && nums[i]>a){
                b=nums[i];
            }
            //Checking value of 3 number and checking if b>a
            if(nums[i]>b && b>a){
                return true;
            }
        }
        return false;
    }
}