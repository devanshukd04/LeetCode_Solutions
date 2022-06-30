class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        long minsum=Long.MAX_VALUE;
        while(i<nums.length){
            int a=nums[i];
            long sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=Math.abs(nums[j]-a);
            }
            if(minsum>sum){
                minsum=sum;
            }
            ++i;
        }
        return (int)minsum;
    }
}