class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        int length=palindrome.length();
        StringBuffer ans=new StringBuffer(palindrome);
        int mid=length/2-1;
        for(int i=0;i<=mid;i++){
            if(palindrome.charAt(i)!='a'){
                ans.replace(i,i+1,"a");
                return ans.toString();
            }
        }
        ans.replace(palindrome.length()-1,palindrome.length(),"b");
        return ans.toString();
    }
}