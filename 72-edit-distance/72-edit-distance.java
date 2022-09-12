class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word2.length();i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                 if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));   
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int helper(String word1, String word2, int[][] dp, int i, int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=helper(word1,word2,dp,i-1,j-1);
        }
        return dp[i][j]=1+Math.min(helper(word1,word2,dp,i,j-1),Math.min(helper(word1,word2,dp,i-1,j),helper(word1,word2,dp,i-1,j-1)));
    }
}