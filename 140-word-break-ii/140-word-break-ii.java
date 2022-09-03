class Solution {
    int a=0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        List<String> ans=new ArrayList<String>();
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
        StringBuilder res=new StringBuilder(); 
        helper(dp,wordDict,ans,s,0,res);
        return ans;
    }
    public void helper(int[] dp,List<String> wordDict,List<String> ans,String s,int index,StringBuilder res){
        if(index==s.length()){
            res.delete(res.length()-1,res.length());
            ans.add(res.toString());
            res.append(" ");
            return;
        }
        for(String word:wordDict){
            if((index+word.length()<dp.length) && (dp[index+word.length()]==1) && (s.substring(index,index+word.length()).equals(word))){
                int b=a++;
                res.append(word);
                res.append(" ");
                helper(dp,wordDict,ans,s,index+word.length(),res);
                res.delete(res.length()-word.length()-1,res.length());
            }
        }
    }
}