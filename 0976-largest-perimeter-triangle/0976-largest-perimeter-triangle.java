class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length-1]+nums[nums.length-2]<=nums[0]){
            return -1;
        }
        for(int i=nums.length-3;i>=0;--i){
            if(nums[i]+nums[i+1]>nums[i+2]){
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }
}