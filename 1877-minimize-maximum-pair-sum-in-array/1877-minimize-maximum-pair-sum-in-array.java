class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int pairSum=nums[i]+nums[nums.length-1-i];
            ans=ans>pairSum?ans:pairSum;
        }
        
        return ans;
    }
}