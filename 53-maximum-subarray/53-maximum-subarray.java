class Solution {
    public int maxSubArray(int[] nums) {
        int[] cnums=new int[nums.length];
        int max=Integer.MIN_VALUE;;
        cnums[0]=nums[0];
        boolean stat=true;
        if(nums.length==1){
            return nums[0]; 
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                stat=false;
            }
        }
        if(stat==false){
        if(cnums[0]<0){
            cnums[0]=0;
        }
        for(int i=1;i<nums.length;i++){
            cnums[i]=cnums[i-1]+nums[i];
            if(cnums[i]<0){
                cnums[i]=0;
            }
        }
        }
        else{
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return max;
        }
        for(int i=0;i<nums.length;i++){
            if(max<cnums[i]){
                max=cnums[i];
            }
        }   
        return max;
    }
}