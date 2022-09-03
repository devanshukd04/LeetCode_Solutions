class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            for(String word:wordDict){
                if(i+word.length()<=s.length() && s.substring(i,i+word.length()).equals(word)){
                    if(dp[i+word.length()]==1){
                        dp[i]=1;
                        break;   
                    }
                }
            }
        }
        return dp[0]==1?true:false;
    }
}