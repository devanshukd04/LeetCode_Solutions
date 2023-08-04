class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> dp=new HashMap<String,Boolean>();
        HashSet<String> set=new HashSet<String>(wordDict);
        return helper(s,set,dp);
    }
    public boolean helper(String s, HashSet<String> set, HashMap<String,Boolean> dp){
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        if(set.contains(s)){
            return true;
        }
        for(int i=1;i<s.length();i++){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i),set,dp)){
                dp.put(s,true);
                return true;
            }
        }
        dp.put(s,false);
        return false;
    }
}