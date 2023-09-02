class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        HashSet<String> set=new HashSet<String>();
        for(String key:dictionary){
            set.add(key);
        }
        return helper(dp,0,s,set);
    }
    public int helper(int[] dp, int index, String s, HashSet<String> dictionary){
        if(index==s.length()){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        StringBuffer subString=new StringBuffer();
        int ans=s.length()-index;
        for(int i=index;i<s.length();i++){
            subString.append(s.charAt(i));
            if(dictionary.contains(subString.toString())){
                ans=Math.min(ans,helper(dp,i+1,s,dictionary));
            }
        }
        ans=Math.min(ans,1+helper(dp,index+1,s,dictionary));
        return dp[index]=ans;
    }
}