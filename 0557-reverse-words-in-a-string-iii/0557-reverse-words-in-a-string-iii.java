class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            StringBuilder word=new StringBuilder();
            while(i<s.length() && s.charAt(i)!=' '){
                word.append(s.charAt(i));
                i++;
            }
            word.reverse();
            ans.append(word);
            if(i<s.length()){
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}