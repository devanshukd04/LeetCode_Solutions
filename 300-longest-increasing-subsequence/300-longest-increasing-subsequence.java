class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);   
        }
        return helper(nums,dp,0,-1);
    }
    public int helper(int[] nums,int[][] dp,int i,int prev){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int take=0;
        int notTake=helper(nums,dp,i+1,prev);
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+helper(nums,dp,i+1,i);
        }
        return dp[i][prev+1]=Math.max(take,notTake);
    }
}


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp=new int[nums.length];
//         dp[0]=1;
//         for(int i=1;i<nums.length;i++){
//             int max=1;
//             for(int j=0;j<i;j++){
//                 if(nums[i]>nums[j]){
//                     max=Math.max(max,dp[j]+1);
//                 }
//             }
//             dp[i]=max;
//         }
//         int max=1;
//         for(int x:dp){
//             max=Math.max(max,x);
//         }
//         return max;
//     }
// }
