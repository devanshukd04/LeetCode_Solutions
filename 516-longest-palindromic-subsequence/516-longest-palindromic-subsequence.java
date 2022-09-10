class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1="";
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            s1+=s.charAt(i);
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=s1.length();j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][s1.length()];
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