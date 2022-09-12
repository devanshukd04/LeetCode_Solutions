class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,dp,word1.length()-1,word2.length()-1);
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