class Solution {
    public int maxDepth(String s) {
        int ans=0;
        int depth=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
            }
            else if(s.charAt(i)==')'){
                depth--;
            }
            ans=ans<depth?depth:ans;
        }
        
        return ans;
    }
}