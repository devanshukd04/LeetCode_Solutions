class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(int start=0;start<s.length();start++){
            int[] char_count=new int[26];
            int max_count=0;
            int end=start;
             while(k-(end-start-max_count)>=0 && end<s.length()){
                 max_count=Math.max(max_count,++char_count[s.charAt(end)-'A']);
                 end++;
            }
            ans=Math.max(ans,k-(end-start-max_count)>=0?(end-start):(end-start-1));
        }
        return ans;
    }
}