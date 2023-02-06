class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length/2;i++){
            ans[index++]=nums[i];
            ans[index++]=nums[nums.length/2+i];
        }
        return ans;
    }
}