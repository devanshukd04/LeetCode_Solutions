class Solution {
    int max=0;
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                if(nums1[i]==nums2[j]){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
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