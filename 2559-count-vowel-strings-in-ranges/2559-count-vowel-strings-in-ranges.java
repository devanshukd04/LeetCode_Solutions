class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> set=new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] dp=new int[words.length];
        for(int i=0;i<words.length;i++){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length()-1))){
                if(i==0){
                    dp[i]=1;
                }
                else{
                    dp[i]=dp[i-1]+1;
                }
            }
            else{
                if(i==0){
                    dp[i]=0;
                }
                else{
                    dp[i]=dp[i-1];
                }
            }
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int temp;
            if(start>0){
                temp=dp[end]-dp[start-1];
            }
            else{
                temp=dp[end];
            }
            ans[i]=temp;
        }
        return ans;
    }
}