class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int a,b;
        for(int i=0;i+k<=nums.length;i++){
            a=nums[i];
            b=nums[i+k-1];
            min=min<(nums[i+k-1]-nums[i])?min:(nums[i+k-1]-nums[i]);
        }
        return min;
    }
}