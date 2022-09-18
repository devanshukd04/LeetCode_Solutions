class Solution {
    public int longestContinuousSubstring(String s) {
        //Stores the ans, maximum longest continous subarray
        int ans=0;
        int len=0;
        //Stores the value of previous character in integer form(ascii)
        int prev=-1;
        for(int i=0;i<s.length();i++){
            //If prev==-1 means we are at the first character of the string
            if(prev==-1){
                len++;
                prev=s.charAt(i)-'a';
            }
            else{
                //If current character value is just 1 greater then previous character then it is part of continous substring and now we update current character as previous character andd increment len by 1
                if(s.charAt(i)-'a'==prev+1){
                    len++;
                    prev=s.charAt(i)-'a';
                }
                //Else current character is now the previous character and length is 1
                else{
                    len=1;
                    prev=s.charAt(i)-'a';
                }
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}