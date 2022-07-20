class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size=Integer.MAX_VALUE;
        if(nums.length==0){
            return 0;
        }
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int a=i;
            int b=nums.length-1;
            while(a<=b){
                if(sum[b]-sum[a]+nums[a]>=target){
                    size=(b-a+1)<size?(b-a+1):size;
                    b--;
                }
                else{
                    break;
                }
            }
        }
        return size==Integer.MAX_VALUE?0:size;
    }
}