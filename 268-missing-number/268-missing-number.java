class Solution {
    public int missingNumber(int[] nums) {
        int[] a=new int[nums.length];
        int b=0;
        for(int i=0;i<nums.length;i++){
            b=nums[i];
            if(b<nums.length){
                a[b]=1;   
            }
        }
        for(int i=0;i<nums.length;i++){
            if(a[i]!=1){
                return i;
            }
        }
        return nums.length;
    }
}