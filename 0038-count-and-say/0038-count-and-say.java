class Solution {
    public String countAndSay(int n) {
        return helper(n);        
    }
    public String helper(int n){
        if(n==1){
            return "1";
        }
        String s=countAndSay(n-1);
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int freq=1;
            char ch=s.charAt(i);
            i++;
            while(i<s.length() && s.charAt(i)==ch){
                i++;
                freq++;
            }
            ans.append(freq);
            ans.append(ch);
            i--;
        }
        return ans.toString();
    }
}