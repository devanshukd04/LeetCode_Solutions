class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1="";
        int[][] dp=new int[s.length()][s.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        for(int i=s.length()-1;i>=0;i--){
            s1+=s.charAt(i);
        }
        return helper(s,s1,dp,s.length()-1,s.length()-1);
    }
    public int helper(String s,String s1,int[][] dp,int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s1.charAt(j)){
            return dp[i][j]=1+helper(s,s1,dp,i-1,j-1);
        }
        return dp[i][j]=Math.max(helper(s,s1,dp,i,j-1),helper(s,s1,dp,i-1,j));
    }
}