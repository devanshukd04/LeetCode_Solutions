class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int k=i+1;
            if(nums[i]==nums[k]){
                    return true;
            }
        }
        return false;
    }
}