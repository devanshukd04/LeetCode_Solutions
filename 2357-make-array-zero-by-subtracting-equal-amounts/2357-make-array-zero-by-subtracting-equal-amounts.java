class Solution {
    public int minimumOperations(int[] nums) {
        int i=0;
        int count=0;
        Arrays.sort(nums);
        while(i<nums.length){
            if(nums[i]<=0){
                i++;
            }
            else{
                ++count;
                int a=nums[i];
                int j=i;
                while(j<nums.length){
                    nums[j]-=a;
                    j++;
                }
            }
        }
        return count;
    }
}