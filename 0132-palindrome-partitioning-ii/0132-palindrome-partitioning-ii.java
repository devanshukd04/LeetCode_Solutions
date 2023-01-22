class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,dp,0)-1;
    }
    public int helper(String s,int[] dp,int index){
        if(index==s.length()){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int min=Integer.MAX_VALUE;
        for(int i=index;i<s.length();i++){
            if(checkPalindrome(s,index,i)){
                String s1=s.substring(index,i+1);
                min=Math.min(min,1+helper(s,dp,i+1));
            }
        }
        return dp[index]=min;
    }
    public boolean checkPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}