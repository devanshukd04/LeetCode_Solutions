class Solution {
    public void sortColors(int[] nums) {
        int temp;
        boolean stat=false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                    stat=true;
                }
            }
            if(!stat){
                break;
            }
        }
    }
}