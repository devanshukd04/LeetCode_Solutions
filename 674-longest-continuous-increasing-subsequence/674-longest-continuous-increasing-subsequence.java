class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
               count++; 
            }
            else{
                ans=ans<count?count:ans;
                count=1;
            }
        }
        ans=ans<count?count:ans;
        return ans;
    }
}