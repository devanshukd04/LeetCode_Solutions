class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][][] dp=new Integer[nums1.length+1][nums2.length+1][2];
        return helper(nums1,nums2,dp,0,0,0);
    }
    public int helper(int[] nums1, int[] nums2, Integer[][][] dp, int index1, int index2, int taken){
        if(index1>=nums1.length || index2>=nums2.length){
            if(taken==0){
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        if(dp[index1][index2][taken]!=null){
            return dp[index1][index2][taken];
        }
        int notTake1=helper(nums1,nums2,dp,index1+1,index2,taken);
        int notTake2=helper(nums1,nums2,dp,index1,index2+1,taken);
        int take=(nums1[index1]*nums2[index2])+helper(nums1,nums2,dp,index1+1,index2+1,1);
        return dp[index1][index2][taken]=Math.max(take,Math.max(notTake1,notTake2));
    }
}