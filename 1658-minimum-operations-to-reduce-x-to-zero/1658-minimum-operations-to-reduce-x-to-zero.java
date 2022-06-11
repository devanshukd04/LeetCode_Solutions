class Solution {
    public int minOperations(int[] nums, int x) {
        int length=-1;
        int sum=0;
        int csum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int l=0,r=0;r<nums.length;r++){
           csum+=nums[r];
            while(l<=r && csum>sum-x){
                csum-=nums[l++];
            }
            if(csum==sum-x){
                length=Math.max(length,r-l+1);
            }
        }
        if(length==-1){
            return -1;
        }
        return nums.length-length;
    }
}