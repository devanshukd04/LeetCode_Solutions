class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(text1,text2,dp,text1.length()-1,text2.length()-1);
    }
    public int helper(String text1,String text2,int[][] dp,int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+helper(text1,text2,dp,i-1,j-1);
        }
        return dp[i][j]=Math.max(helper(text1,text2,dp,i-1,j),helper(text1,text2,dp,i,j-1));
    }
}

