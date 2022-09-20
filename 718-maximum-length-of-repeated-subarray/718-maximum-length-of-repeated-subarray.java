class Solution {
    int max=0;
    public int findLength(int[] nums1, int[] nums2) {
        Integer[][] dp=new Integer[nums1.length][nums2.length];
        helper(nums1,nums2,dp,0,0);
        return max;
    }
    public int helper(int[] nums1,int[] nums2,Integer[][] dp,int i,int j){
        if(i>=nums1.length || j>=nums2.length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int take=0;
        if(nums1[i]==nums2[j]){
            take=1+helper(nums1,nums2,dp,i+1,j+1);
        }
        helper(nums1,nums2,dp,i+1,j);
        helper(nums1,nums2,dp,i,j+1);    
        max=Math.max(max,take);
        return dp[i][j]=take;
    }
}